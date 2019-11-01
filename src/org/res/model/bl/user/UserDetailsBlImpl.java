package org.res.model.bl.user;

import org.res.model.dao.user.UserDetailsDao;
import org.res.model.dao.user.UserDetailsDaoImpl;
import org.res.model.entity.user.UserDetails;

public class UserDetailsBlImpl implements  UserDetailsBl{
	private UserDetailsDao userDetailsDaoImpl;

	public UserDetailsBlImpl() {
		userDetailsDaoImpl = new UserDetailsDaoImpl();
	}

	@Override
	public boolean userLogin(String userId, String password) {
		return userDetailsDaoImpl.userLogin(userId, password);
	}

	@Override
	public boolean insertRecord(UserDetails userdetails) {

		return userDetailsDaoImpl.insertRecord(userdetails);
	}


	@Override
	public String getUserAddress(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean userNameExists(String userId) {
		return userDetailsDaoImpl.userNameExists(userId);
	
	}
}
