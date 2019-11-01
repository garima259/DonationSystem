package org.res.model.bl.ngo;

import java.util.List;

public interface NgoDetailsBl {
	public List<String> getRecordByCategory(String category);
	public List<String> getcategory();
	boolean ngoExists(String ngoName);
	String getNgoId(String ngoName);
}

