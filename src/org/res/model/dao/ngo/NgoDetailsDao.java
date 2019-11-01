package org.res.model.dao.ngo;

import java.util.List;

public interface NgoDetailsDao {
	List<String> getRecordByCategory(String category);
	List<String> getCategory();
	boolean ngoExists(String ngoName);
	String getNgoId (String ngoName);
}

