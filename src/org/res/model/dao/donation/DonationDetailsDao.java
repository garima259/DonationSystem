package org.res.model.dao.donation;

import java.util.List;
import java.util.Map;

import org.res.model.entity.donation.DonationDetails;



public interface DonationDetailsDao {
	List<DonationDetails> getRecordByUserId();
	Map<String, Integer> getRecordByNgoId(String ngoid);
	boolean insertRecord(DonationDetails donationdetails,String ngoName,String userId);
	List<DonationDetails> getAllNgoRecord();
	public boolean insertPickupDetails(String userId, String ngoName, String modeOfDonation, String dateTime);
}

