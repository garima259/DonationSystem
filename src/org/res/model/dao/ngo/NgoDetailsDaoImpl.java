package org.res.model.dao.ngo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.res.model.entity.donation.DonationDetails;
import org.res.util.DbConnectionHelper;



public class NgoDetailsDaoImpl implements NgoDetailsDao {

	Connection connection = null;
	PreparedStatement preparedStatement1 = null;
	PreparedStatement preparedStatement2 = null;
	ResultSet resultSet = null;

	@Override
	public List<String> getCategory() {

		
		List<String> categoryList = new ArrayList<>();

		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement1 = connection.prepareStatement("select Distinct ngoCategory from NgoDetails");
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {

				categoryList.add(resultSet.getString("ngoCategory"));
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
		return categoryList;

	}

	

//	@Override
//	public List<String> getRecordByCategory(String category) {
//		
//		List<String> ngoByCategoryList = new ArrayList<>();
//
//		try {
//			connection = com.ngo.project.util.DbConnectionHelper.getConnection();
//			preparedStatement1 = connection.prepareStatement("select Distinct NGOName from NgoDetails where Category =?");
//			preparedStatement1.setString(1, category);
//			resultSet = preparedStatement1.executeQuery();
//			while (resultSet.next()) {
//
//				ngoByCategoryList .add(resultSet.getString("NGOName"));
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
//		return ngoByCategoryList;
//
//	}
	
	@Override
	public List<String> getRecordByCategory(String category) {
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;

		List<String> ngoIdList = new ArrayList<>();
		List<String> ngoNameList = new ArrayList<>();
		List<Integer> ngoValueList = new ArrayList<>();
		Map<String, Integer> ngoValue = new LinkedHashMap<>();
		List<String> sortedngoList = new ArrayList<>();
		List<String> finalNgoNameList = new ArrayList<>();
		DonationDetails donationDetails = new DonationDetails();
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement1 = connection.prepareStatement(
					"select donationNgoId, (money+food+clothes+volunteer) as Value  from DonationDetails  order by Value asc");
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				ngoIdList.add(resultSet.getString("donationNgoId"));
				ngoValueList.add(resultSet.getInt("Value"));
			}

			for (String ngoIdElement : ngoIdList) {
				preparedStatement2 = connection.prepareStatement("select  ngoName from NgoDetails where ngoId  = ? and ngoCategory= ? ");

				preparedStatement2.setString(1, ngoIdElement);
				preparedStatement2.setString(2, category);

				resultSet = preparedStatement2.executeQuery();
				while (resultSet.next()) {
					ngoNameList.add(resultSet.getString("ngoName"));
				}

			}

			for (int i = 0; i < ngoNameList.size(); i++) {
				ngoValue.put(ngoNameList.get(i), ngoValueList.get(i));
			}
			for ( String key : ngoValue.keySet() ) {
				finalNgoNameList.add(key);
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
		return finalNgoNameList;


	}
	@Override
	public boolean ngoExists(String ngoName) {
		try {
		connection = DbConnectionHelper.getConnection();

		// 2. Query

		preparedStatement1 = connection.prepareStatement("select * from NgoDetails  where ngoName = ?");

		preparedStatement1.setString(1,ngoName );
		
		resultSet = preparedStatement1.executeQuery();
		
		if (resultSet.next()) {
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



	@Override
	public String getNgoId(String ngoName) {
		try {
			connection = DbConnectionHelper.getConnection();

			// 2. Query

			preparedStatement1 = connection.prepareStatement("select ngoId from NgoDetails  where ngoName = ?");

			preparedStatement1.setString(1,ngoName );
			
			resultSet = preparedStatement1.executeQuery();
			String ngoId = resultSet.getString("ngoId");
			if (resultSet.next()) {
				return ngoId;
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

		return null;
	}

}




