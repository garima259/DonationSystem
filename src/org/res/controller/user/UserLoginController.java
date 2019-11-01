package org.res.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.res.model.bl.user.UserDetailsBl;
import org.res.model.bl.user.UserDetailsBlImpl;



public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLoginController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginStatus="";
		HttpSession session=request.getSession();
		UserDetailsBl userDetailsBl= new UserDetailsBlImpl();
		boolean status =userDetailsBl.userLogin(request.getParameter("userName"),request.getParameter( "password"));
		session.setAttribute("userName",request.getParameter("userName"));
		if(status)
		{
			//loginStatus="You have successfully logined";
			//loginStatus="Successful";
			response.sendRedirect("./CategoryOrInputMenu");
		}
		else
		{
			
			//loginStatus="Failed";
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("./oops.jsp");
			requestDispatcher.forward(request, response);
		}
		
		//response.sendRedirect("./LoginStatusPage?loginStatus="+loginStatus);
		
		
			
		
	}

}
