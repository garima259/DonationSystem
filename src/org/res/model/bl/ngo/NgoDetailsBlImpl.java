package org.res.model.bl.ngo;

import java.util.List;

import org.res.model.dao.ngo.NgoDetailsDao;
import org.res.model.dao.ngo.NgoDetailsDaoImpl;



public class NgoDetailsBlImpl implements NgoDetailsBl {
	NgoDetailsDao ngoDetailsDaoImpl;
	public NgoDetailsBlImpl()
	{
		ngoDetailsDaoImpl= new NgoDetailsDaoImpl();
	}
	@Override
	public List<String> getcategory() {
		ngoDetailsDaoImpl= new NgoDetailsDaoImpl();
		List<String> ngoCategory= ngoDetailsDaoImpl.getCategory();
		return ngoCategory;
	}

	
	@Override
	public List<String> getRecordByCategory(String category) {
		ngoDetailsDaoImpl= new NgoDetailsDaoImpl();
		List<String> ngoByCategory= ngoDetailsDaoImpl.getRecordByCategory(category);
		return ngoByCategory;
	}
	@Override
	public boolean ngoExists(String ngoName) {
		boolean status = ngoDetailsDaoImpl.ngoExists(ngoName);
		return status ;
		
		
	}
	
	@Override
	public String getNgoId(String ngoName) {
		ngoDetailsDaoImpl= new NgoDetailsDaoImpl();
		return( ngoDetailsDaoImpl.getNgoId(ngoName));
	}
	


}