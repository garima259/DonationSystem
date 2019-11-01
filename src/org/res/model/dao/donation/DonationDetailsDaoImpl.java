package org.res.model.dao.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.res.model.entity.donation.DonationDetails;
import org.res.util.DbConnectionHelper;



public class DonationDetailsDaoImpl implements DonationDetailsDao {
	Connection connection = null;
	ResultSet resultSet = null;

//	@Override
//	public UserDetails getRecordByUserId(int userid) {
//		return null;
//		PreparedStatement preparedStatement1 = null;
//		PreparedStatement preparedStatement2 = null;
//		
//		Map<String, Integer> ngoValueMap = new HashMap<>();
//		String ngoId = "", ngoName = "";
//		int ngoValue = 0;
//		DonationDetails donationDetails = new DonationDetails();
//		try {
//			connection = com.ngo.project.util.DbConnectionHelper.getConnection();
//			preparedStatement1 = connection.prepareStatement(
//					"select NgoId, (Money+Food+Clothes+Volunteer) as Value  from DonationDetails where NGOId = ?  order by value desc");
//			preparedStatement1.setString(1, ngoid);
//			resultSet = preparedStatement1.executeQuery();
//			while (resultSet.next()) {
//				ngoId = resultSet.getString("NgoId");
//				ngoValue = resultSet.getInt("Value");
//			}
//
//			preparedStatement2 = connection.prepareStatement("select  NGOName from NgoDetails where NGOId  = ? ");
//
//			preparedStatement2.setString(1, ngoId);
//
//			resultSet = preparedStatement2.executeQuery();
//			while (resultSet.next()) {
//				ngoName = (resultSet.getString("NGOName"));
//			}
//
//			ngoValueMap.put(ngoName, ngoValue);
//
//		} catch (SQLException sqlexception) {
//			sqlexception.printStackTrace();
//
//		} finally {
//
//			try {
//				// 4. Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return ngoValueMap;
//	}
	@Override
	public List<DonationDetails> getRecordByUserId() {
		PreparedStatement preparedStatement1 = null;
		List<DonationDetails> donationDetailsList = new ArrayList<>();
		DonationDetails donationDetails;
		String firstName, lastName;
		Integer money, food, volunteer, clothes;

		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement1 = connection.prepareStatement(
					"SELECT  UserDetails.firstName,UserDetails.lastName,Sum(DonationDetails.money) as Money,Sum(DonationDetails.food)as Food,Sum(DonationDetails.clothes)as Clothes,Sum(DonationDetails.volunteer)as Volunteer\r\n"
							+ "					FROM DonationDetails \r\n"
							+ "					INNER JOIN UserDetails ON UserDetails.userId = DonationDetails.userId group by UserDetails.firstName,UserDetails.lastName order by Money desc;");
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				firstName = resultSet.getString("firstName").toString();
				lastName = resultSet.getString("lastName").toString();
				money = resultSet.getInt("Money");
				volunteer = resultSet.getInt("Volunteer");
				food = resultSet.getInt("Food");
				clothes = resultSet.getInt("Clothes");
				donationDetails = new DonationDetails(money, food, clothes, volunteer, firstName, lastName);
				donationDetailsList.add(donationDetails);
			}

		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return donationDetailsList;
	}

	// For Admin Use to get value of ngo by entering ngoid
	@Override
	public Map<String, Integer> getRecordByNgoId(String ngoid) {

		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;

		Map<String, Integer> ngoValueMap = new HashMap<>();
		String ngoId = "", ngoName = "";
		int ngoValue = 0;
		DonationDetails donationDetails = new DonationDetails();
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement1 = connection.prepareStatement(
					"select donationNgoId, (Money+Food+Clothes+Volunteer) as Value  from DonationDetails where donationNgoId = ?  order by value desc");
			preparedStatement1.setString(1, ngoid);
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				ngoId = resultSet.getString("donationNgoId");
				ngoValue = resultSet.getInt("Value");
			}

			preparedStatement2 = connection.prepareStatement("select  ngoName from NgoDetails where ngoId  = ? ");

			preparedStatement2.setString(1, ngoId);

			resultSet = preparedStatement2.executeQuery();
			while (resultSet.next()) {
				ngoName = (resultSet.getString("ngoName"));
			}

			ngoValueMap.put(ngoName, ngoValue);

		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ngoValueMap;

	}

	// For Admin Use to get value of all ngos
//	@Override
//	public Map<String, Integer> getAllNgoRecord() {
//	
//		PreparedStatement preparedStatement1 = null;
//		PreparedStatement preparedStatement2 = null;
//
//		List<String> ngoIdList = new ArrayList<>();
//		List<String> ngoNameList = new ArrayList<>();
//		List<Integer> ngoValueList = new ArrayList<>();
//		Map<String, Integer> ngoValue = new LinkedHashMap<>();
//		DonationDetails donationDetails = new DonationDetails();
//		try {
//			connection = com.ngo.project.util.DbConnectionHelper.getConnection();
//			preparedStatement1 = connection.prepareStatement(
//					"select NgoId, (Money+Food+Clothes+Volunteer) as Value  from DonationDetails  order by Value desc");
//			resultSet = preparedStatement1.executeQuery();
//			while (resultSet.next()) {
//				ngoIdList.add(resultSet.getString("NgoId"));
//				ngoValueList.add(resultSet.getInt("Value"));
//			}
//
//			for (String ngoIdElement : ngoIdList) {
//				preparedStatement2 = connection.prepareStatement("select  NGOName from NgoDetails where NGOId  = ? ");
//
//				preparedStatement2.setString(1, ngoIdElement);
//
//				resultSet = preparedStatement2.executeQuery();
//				while (resultSet.next()) {
//					ngoNameList.add(resultSet.getString("NGOName"));
//				}
//
//			}
//
//			for (int i = 0; i < ngoNameList.size(); i++) {
//				ngoValue.put(ngoNameList.get(i), ngoValueList.get(i));
//			}
//
//		} catch (SQLException sqlexception) {
//			sqlexception.printStackTrace();
//
//		} finally {
//
//			try {
//				// 4. Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return ngoValue;
//
//	}
	@Override
	public List<DonationDetails> getAllNgoRecord() {

		PreparedStatement preparedStatement1 = null;
		List<DonationDetails> donationDetailsList = new ArrayList<>();
		DonationDetails donationDetails;
		String ngoName;
		Integer money, food, volunteer, clothes;

		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement1 = connection.prepareStatement(
					"SELECT  NgoDetails.ngoName,Sum(DonationDetails.money) as Money,Sum(DonationDetails.food)as Food,Sum(DonationDetails.clothes)as Clothes,Sum(DonationDetails.volunteer)as Volunteer\r\n"
							+ "FROM DonationDetails \r\n"
							+ "INNER JOIN NgoDetails ON NgoDetails.ngoId = DonationDetails.donationNgoId group by NgoDetails.ngoName order by Money;");
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				ngoName = resultSet.getString("ngoName").toString();
				money = resultSet.getInt("Money");
				volunteer = resultSet.getInt("Volunteer");
				food = resultSet.getInt("Food");
				clothes = resultSet.getInt("Clothes");
				donationDetails = new DonationDetails(ngoName, money, food, clothes, volunteer);
				donationDetailsList.add(donationDetails);
			}

		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return donationDetailsList;

	}

	@Override
	public boolean insertRecord(DonationDetails donationDetails, String ngoName, String userId) {

		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;

		try {
			connection = DbConnectionHelper.getConnection();
System.out.println(ngoName);
			// 2. Query
			preparedStatement1 = connection.prepareStatement("select ngoId from NgoDetails where ngoName = ?");
			preparedStatement1.setString(1, ngoName);
			resultSet = preparedStatement1.executeQuery();
			String ngoId = "null";
			System.out.println(resultSet);
			if(resultSet.next() ) {
				ngoId = resultSet.getString("ngoId");
			}
			System.out.println(ngoId);
			preparedStatement2 = connection.prepareStatement("insert into DonationDetails values(?,?,?,?,?,?)");

			preparedStatement2.setString(1, userId);
			preparedStatement2.setString(2, ngoId);
			System.out.println(ngoId);
			preparedStatement2.setInt(3, donationDetails.getMoney());
			preparedStatement2.setInt(4, donationDetails.getFood());
			preparedStatement2.setInt(5, donationDetails.getClothes());
			preparedStatement2.setInt(6, donationDetails.getVolunteer());

			int status = preparedStatement2.executeUpdate();
			// 3.Process Result
			if (status > 0) {
				return true;
			}
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

//	@Override
//	public Map<String,Integer> getRecordByUserId(String userid) {
//		Connection connection = null;
//		PreparedStatement preparedStatement1 = null;
//		PreparedStatement preparedStatement2 = null;
//		ResultSet resultSet = null;
//	Scanner sc = new Scanner(System.in);
//		//int ngoMoney=0, ngoFood=0, ngoClothes=0, ngoVoluteer=0;
//		List<String> donationIdList=new ArrayList<>();
//		List<String> userIdList=new ArrayList<>();
//      List<String> ngoIdList=new ArrayList<>();
//		
//	
//	List<Integer> ngoValueList=new ArrayList<>();
//		Map<String, Integer> ngoValue= new TreeMap<>();
//		DonationDetails donationDetails = new DonationDetails();
//		try {
//			connection = com.ngo.project.util.DbConnectionHelper.getConnection();
//
//			// 2. Query
//
//			preparedStatement1 = connection.prepareStatement("select UserId,NgoId,DonationId, (Money+Food+Clothes+Volunteer) as Value  from DonationDetails where UserId = ?  order by value desc");
//			System.out.println(preparedStatement1);
//			preparedStatement1.setString(1, userid);
//
//			resultSet = preparedStatement1.executeQuery();
//			System.out.println(resultSet);
//			while(resultSet.next())
//			{
//				 userIdList.add(resultSet.getString("UserId"));
//				 ngoValueList.add(resultSet.getInt("Value"));
//				 System.out.println("The User Id"+""+resultSet.getString("UserId"));
//					System.out.println("The User Id"+""+resultSet.getInt("Value"));
//			}
//						
//		} catch (SQLException sqlexception) {
//			sqlexception.printStackTrace();
//
//		} finally 
//	{
//
//			try {
//				// 4. Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return ngoValue;
//
//	}
	@Override
	public boolean insertPickupDetails(String userId, String ngoName, String modeOfDonation, String dateTime) {

		PreparedStatement preparedStatement1 = null;
		DonationDetails donationDetails;
		String ngoId = "";
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement1 = connection.prepareStatement("insert into  CollectionDetails values (?,?,?,?)");
			preparedStatement1.setString(1, userId);
			preparedStatement1.setString(2, ngoId);
			preparedStatement1.setString(3, modeOfDonation);
			preparedStatement1.setString(4, dateTime);
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				return true;
			}

		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}
}
