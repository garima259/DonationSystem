package org.res.model.dao.user;

import org.res.model.entity.user.UserDetails;

public interface UserDetailsDao {

	boolean insertRecord(UserDetails userdetails);
	boolean userLogin(String userId, String password);
	String getUserAddress(String userId);
	boolean userNameExists(String userId);
}
