package org.res.model.bl.admin;

import org.res.model.entity.admin.AdminDetails;
import org.res.model.entity.ngo.NgoDetails;

public interface AdminDetailsBl {
public boolean adminLogin (AdminDetails adminDetails );
public boolean addNgo(NgoDetails ngoDetails);
public boolean removeNgo(String ngoName);
}

