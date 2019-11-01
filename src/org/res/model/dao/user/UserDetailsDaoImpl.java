package org.res.model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.res.model.entity.user.UserDetails;
import org.res.util.DbConnectionHelper;


public class UserDetailsDaoImpl implements UserDetailsDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	// User login
	@Override
	public boolean userLogin(String userId, String password) {

		connection = DbConnectionHelper.getConnection();

		try {

			preparedStatement = connection
					.prepareStatement("select userId from UserDetails where userId = ? and password =? ");

			preparedStatement.setString(1, userId);

			preparedStatement.setString(2, password);

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

	@Override
	public boolean insertRecord(UserDetails userdetails) {
		
		try {
			connection = DbConnectionHelper.getConnection();

			preparedStatement = connection.prepareStatement("insert into UserDetails values(?,?,?,?,?,?)");

			preparedStatement.setString(1, userdetails.getUserId());
			preparedStatement.setString(2, userdetails.getPassword());
			preparedStatement.setString(3, userdetails.getFirstName());
			preparedStatement.setString(4, userdetails.getLastName());
			preparedStatement.setString(5, userdetails.getEmailId());
			preparedStatement.setString(6, userdetails.getAddress());
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
	public String getUserAddress(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userNameExists(String userId) {
		try {
			connection = DbConnectionHelper.getConnection();

			preparedStatement = connection.prepareStatement("select userid from  UserDetails where userid = ?");

			preparedStatement.setString(1, userId);
			
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
