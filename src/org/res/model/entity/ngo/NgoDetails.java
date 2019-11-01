package org.res.model.entity.ngo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NgoDetails {
	@Id
	private String ngoId;
	private String ngoCategory;
	private String ngoName;

	public NgoDetails() {

	}

	public NgoDetails(String ngoId, String ngoCategory, String ngoName) {
		super();
		this.ngoId = ngoId;
		this.ngoCategory = ngoCategory;
		this.ngoName = ngoName;
	}

	public String getNgoId() {
		return ngoId;
	}

	public void setNgoId(String ngoId) {
		this.ngoId = ngoId;
	}

	public String getNgoCategory() {
		return ngoCategory;
	}

	public void setNgoCategory(String ngoCategory) {
		this.ngoCategory = ngoCategory;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	@Override
	public String toString() {
		return "NgoDetails [ngoId=" + ngoId + ", ngoCategory=" + ngoCategory + ", ngoName=" + ngoName + "]";
	}

}