package org.res.model.bl.admin;

import org.res.model.dao.admin.AdminDetailsDao;
import org.res.model.dao.admin.AdminDetailsDaoImpl;
import org.res.model.entity.admin.AdminDetails;
import org.res.model.entity.ngo.NgoDetails;

public class AdminDetailsBlImpl implements AdminDetailsBl {
	AdminDetailsDao adminDetailsDao;
	public AdminDetailsBlImpl()
	{
		adminDetailsDao = new AdminDetailsDaoImpl();
	}

	@Override
	public boolean adminLogin(AdminDetails adminDetails) {
		adminDetailsDao = new AdminDetailsDaoImpl();
		boolean status =adminDetailsDao.adminLogin( adminDetails);
		return status;
	}

	@Override
	public boolean addNgo(NgoDetails ngoDetails) {
		boolean status,status1;
		adminDetailsDao = new AdminDetailsDaoImpl();
		String ngoName=ngoDetails.getNgoName();
		status=adminDetailsDao.ngoExists(ngoName);
		if (status== false)
		{
		status1 =adminDetailsDao.addNgo( ngoDetails);
		return status1;
		}
		System.out.println("NGO already exists!");
		return false;
	}

	@Override
	public boolean removeNgo(String ngoName) {
		adminDetailsDao = new AdminDetailsDaoImpl();
		boolean status=adminDetailsDao.ngoExists(ngoName);
		
		if (status== false)
		{System.out.println("NGO does not exist!");
		return false;
		}
		boolean status1 =adminDetailsDao.removeNgo( ngoName);
		return status1;
	}


}
