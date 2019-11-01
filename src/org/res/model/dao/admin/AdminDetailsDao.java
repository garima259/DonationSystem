package org.res.model.dao.admin;

import org.res.model.entity.admin.AdminDetails;
import org.res.model.entity.ngo.NgoDetails;

public interface AdminDetailsDao {
	public boolean adminLogin(AdminDetails adminDetails);
	public boolean addNgo(NgoDetails ngoDetails);
	public boolean removeNgo(String ngoName);
	public boolean ngoExists(String ngoName );
}