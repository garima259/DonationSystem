package org.res.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.res.model.bl.donation.DonationDetailsBl;
import org.res.model.bl.donation.DonationDetailsBlImpl;
import org.res.model.entity.donation.DonationDetails;




public class DonationMethodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DonationMethodController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String donationMethod="",ngoName="";
		int donationValue=0;
		DonationDetailsBl donationDetailsBl =new DonationDetailsBlImpl();
		
		 if(request.getParameter("donationMethod")!= null & request.getParameter("donationValue")!= null)
		{
			 donationMethod=request.getParameter("donationMethod");
			session.setAttribute("donationMethod", donationMethod);
			 donationValue=Integer.parseInt(request.getParameter("donationValue"));
			session.setAttribute("donationValue", donationValue);
			System.out.println("Donation Method and value not null");
			
		}
		
		else
		{
			
			System.out.println("something is null ");
		}
		DonationDetails donationDetails = new DonationDetails();
		donationDetails.setDonationNgoId((String)session.getAttribute("ngoId"));
		switch(donationMethod)
		{
		case "Money":
		
			donationDetails.setMoney(donationValue);
			
		break;
		case "Food":
		
			donationDetails.setFood(donationValue);
			
		break;
		case "Clothes":
		
			donationDetails.setClothes(donationValue);
			
		
		case "Volunteering":
		
			donationDetails.setVolunteer(donationValue);
			
			
		}
		donationDetailsBl.insertRecord(donationDetails, (String)session.getAttribute("ngoName"),(String)session.getAttribute("userName"));
		if(donationMethod.equals("Volunteering"))
		{
			response.sendRedirect("./ThankYou.jsp");
		}
		
		else 
		{
		response.sendRedirect("./DonationMode.jsp");
		}
	}

}
