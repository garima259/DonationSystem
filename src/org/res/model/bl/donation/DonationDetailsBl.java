package org.res.model.bl.donation;

import java.util.List;
import java.util.Map;

import org.res.model.entity.donation.DonationDetails;



public interface DonationDetailsBl {
	public List<DonationDetails> getRecordByUserId();

	public Map<String,Integer> getRecordByNgoId(String ngoId);

	public boolean insertRecord(DonationDetails donationdetails, String ngoName, String userId);

	public List<DonationDetails> getAllNgoRecord();
	public boolean insertPickupDetails(String userId, String ngoName, String modeOfDonation, String dateTime);
}