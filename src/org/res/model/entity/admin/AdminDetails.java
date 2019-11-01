package org.res.model.entity.admin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminDetails {
	@Id
	private String adminId;
	private String password;

	public AdminDetails(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
