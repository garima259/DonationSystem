package org.res.model.bl.user;

import org.res.model.entity.user.UserDetails;

public interface UserDetailsBl {


	boolean insertRecord(UserDetails userdetails);

	boolean userLogin(String userId, String password);
	
	String getUserAddress(String userId);

	boolean userNameExists(String userId);
}
