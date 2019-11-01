package org.res.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.res.model.bl.admin.AdminDetailsBl;
import org.res.model.bl.admin.AdminDetailsBlImpl;
import org.res.model.bl.donation.DonationDetailsBl;
import org.res.model.bl.donation.DonationDetailsBlImpl;
import org.res.model.entity.ngo.NgoDetails;

public class AddOrRemoveNgoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddOrRemoveNgoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String ngoName = "", ngoCategory = "";
		AdminDetailsBl adminDetailsBlImpl;
		NgoDetails ngoDetails ;
		boolean status = true;
		if (request.getParameter("addNgoName") != null) {
			ngoName = request.getParameter("addNgoName");
			ngoCategory = request.getParameter("addNgoCategory");
			adminDetailsBlImpl = new AdminDetailsBlImpl();
			ngoDetails= new NgoDetails(ngoName+"_123",ngoCategory,ngoName);
			status = adminDetailsBlImpl.addNgo(ngoDetails);
			if(status)
			{
				response.sendRedirect("./NgoAdded");
			}
			else
			{
				response.sendRedirect("./Oops");
			}
		}
		
		else if (request.getParameter("removeNgoName") != null) {
			ngoName = request.getParameter("removeNgoName");
			adminDetailsBlImpl = new AdminDetailsBlImpl();
			status = adminDetailsBlImpl.removeNgo(ngoName);
			if(status)
			{
				response.sendRedirect("./NgoRemoved");
			}
			else
			{
				response.sendRedirect("./Oops");
			}
		}

	}

}
