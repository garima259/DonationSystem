package org.res.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.res.model.bl.admin.AdminDetailsBl;
import org.res.model.bl.admin.AdminDetailsBlImpl;
import org.res.model.entity.admin.AdminDetails;




public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLoginController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		AdminDetails adminDetails= new AdminDetails(request.getParameter("adminId"),request.getParameter("password"));
		AdminDetailsBl adminDetailsBl = new AdminDetailsBlImpl();
		boolean status = adminDetailsBl.adminLogin(adminDetails);
		
		if(status)
		{
			response.sendRedirect("./AdminMenu.jsp");
		}
		else
		{
			response.sendRedirect("./FailedLogin.jsp");
		}
		
	}

}
