package org.res.model.bl.donation;

import java.util.List;
import java.util.Map;

import org.res.model.dao.donation.DonationDetailsDao;
import org.res.model.dao.donation.DonationDetailsDaoImpl;
import org.res.model.entity.donation.DonationDetails;


public class DonationDetailsBlImpl implements DonationDetailsBl {
	DonationDetailsDao donationDetailsDao;

	public DonationDetailsBlImpl() {
		donationDetailsDao = new DonationDetailsDaoImpl();

	}

	@Override
	public List<DonationDetails> getRecordByUserId() {
		DonationDetailsDaoImpl donationDetailsDaoImpl = new DonationDetailsDaoImpl();
		List<DonationDetails> userList = donationDetailsDaoImpl.getRecordByUserId();
		return userList;
	}

	@Override
	public Map<String, Integer> getRecordByNgoId(String ngoId) {
		DonationDetailsDaoImpl donationDetailsDaoImpl = new DonationDetailsDaoImpl();
		Map<String, Integer> ngoValue = donationDetailsDaoImpl.getRecordByNgoId(ngoId);
		return ngoValue;
	}

	@Override
	public boolean insertRecord(DonationDetails donationdetails, String ngoName, String userId) {
		donationDetailsDao = new DonationDetailsDaoImpl();
		boolean status = donationDetailsDao.insertRecord(donationdetails, ngoName, userId);
		return status;
	}

	@Override
	public List<DonationDetails> getAllNgoRecord() {
		DonationDetailsDaoImpl donationDetailsDaoImpl = new DonationDetailsDaoImpl();
		List<DonationDetails> ngoValue = donationDetailsDaoImpl.getAllNgoRecord();
		return ngoValue;

	}

	@Override
	public boolean insertPickupDetails(String userId, String ngoName, String modeOfDonation, String dateTime) {
		boolean status = donationDetailsDao.insertPickupDetails(userId, ngoName, modeOfDonation, dateTime);
		return status;
	}
}

