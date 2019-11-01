package org.res.controller.admin;

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


public class GetNgoDonationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetNgoDonationController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		DonationDetailsBl donationDetailsBlImpl = new DonationDetailsBlImpl();
		List<DonationDetails> donationList = donationDetailsBlImpl.getAllNgoRecord();
		session.setAttribute("donationList", donationList);
		response.sendRedirect("./NgoDonation.jsp");

	}
}
