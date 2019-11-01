package org.res.model.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.res.model.entity.admin.AdminDetails;
import org.res.model.entity.ngo.NgoDetails;
import org.res.util.DbConnectionHelper;

public class AdminDetailsDaoImpl implements AdminDetailsDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	PreparedStatement preparedStatement1 = null;
	ResultSet resultSet = null;

	@Override
	public boolean adminLogin(AdminDetails adminDetails) {

		connection = DbConnectionHelper.getConnection();

		// 2. Query
		try {
			int count = 0;
			preparedStatement = connection
					.prepareStatement("select Id from AdminDetails where adminId = ? and password =? ");

			preparedStatement.setString(1, adminDetails.getAdminId());
			preparedStatement.setString(2, adminDetails.getPassword());

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count++;
			}
			if (count > 0) {

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
	public boolean addNgo(NgoDetails ngoDetails) {

		try {
			connection = DbConnectionHelper.getConnection();

			// 2. Query

			preparedStatement = connection.prepareStatement("insert into NgoDetails values(?,?,?)");

			preparedStatement.setString(1, ngoDetails.getNgoId());
			preparedStatement.setString(2, ngoDetails.getNgoCategory());
			preparedStatement.setString(3, ngoDetails.getNgoName());

			int status = preparedStatement.executeUpdate();
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

	@Override
	public boolean removeNgo(String ngoName) {
		try {

			connection = DbConnectionHelper.getConnection();

			preparedStatement = connection.prepareStatement("delete from NgoDetails where ngoName = ?");

			preparedStatement.setString(1, ngoName);

			int status = preparedStatement.executeUpdate();
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

	@Override
	public boolean ngoExists(String ngoName) {
		try {
			connection = DbConnectionHelper.getConnection();

			// 2. Query

			preparedStatement = connection.prepareStatement("select * from NgoDetails  where ngoName = ?");

			preparedStatement.setString(1, ngoName);

			resultSet = preparedStatement.executeQuery();

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

}
