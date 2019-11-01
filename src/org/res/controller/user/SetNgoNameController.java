package org.res.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class SetNgoNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SetNgoNameController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ngoName="";
		HttpSession session=request.getSession(false);
		//DonationDetailsBl donationDetailsBl =new DonationDetailsBlImpl();
		if(request.getParameter("ngoList")!= null)
		{
			 ngoName=request.getParameter("ngoList");
			session.setAttribute("ngoName", ngoName);
		}
		response.sendRedirect("./DonationDetails.jsp");
		
	}

}
