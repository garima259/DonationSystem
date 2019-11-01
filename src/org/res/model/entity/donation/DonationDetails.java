package org.res.model.entity.donation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DonationDetails {
	@Id
	private String donationId;
	private String firstName;
	private String lastName;
	private String donationNgoId;
	private int money;
	private int food;
	private int clothes;
	private int volunteer;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public DonationDetails() {

	}

	public DonationDetails( int money, int food, int clothes,
			int volunteer,String firstName,String lastName) {
		super();
		this.money = money;
		this.food = food;
		this.clothes = clothes;
		this.volunteer = volunteer;
		this.firstName =firstName;
		this.lastName =lastName;
	}
	
	public DonationDetails(String donationNgoId, int money, int food, int clothes,
			int volunteer) {
		super();
		this.donationNgoId = donationNgoId;
		this.money = money;
		this.food = food;
		this.clothes = clothes;
		this.volunteer = volunteer;
//		System.out.format("%32s%10d%10d%10d%10d", ngoName ,
//				 money ,  food  , clothes   , volunteer);
	}

	public String getDonationId() {
		return donationId;
	}

	public void setDonationId(String donationId) {
		this.donationId = donationId;
	}

	
	public String getDonationNgoId() {
		return donationNgoId;
	}

	public void setDonationNgoId(String ngoId) {
		this.donationNgoId = ngoId;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getClothes() {
		return clothes;
	}

	public void setClothes(int clothes) {
		this.clothes = clothes;
	}

	public int getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(int volunteer) {
		this.volunteer = volunteer;
	}

	@Override
	public String toString() {
		
		return donationNgoId + 
				 " "+ money +  food  + clothes   + volunteer  ;
	}
	

}
