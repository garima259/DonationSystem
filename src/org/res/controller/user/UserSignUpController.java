package org.res.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.res.model.bl.user.UserDetailsBl;
import org.res.model.bl.user.UserDetailsBlImpl;
import org.res.model.entity.user.UserDetails;



public class UserSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserSignUpController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String signUpStatus="";
		UserDetails userDetails = new UserDetails(request.getParameter("userId"),request.getParameter("password"),request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("emailId"),request.getParameter("address"));
		UserDetailsBl userDetailsBl= new UserDetailsBlImpl();
		
		boolean status =userDetailsBl.insertRecord(userDetails);
		boolean statusUserName= userDetailsBl.userNameExists(userDetails.getUserId());
		session.setAttribute("userId",request.getParameter("userId"));
		if(status==true & userDetails.getUserId() != null & userDetails.getAddress() != null & userDetails.getEmailId() != null & userDetails.getFirstName() != null &  userDetails.getPassword() != null &  userDetails.getLastName() != null  )
		{
			//loginStatus="You have successfully logined";
			signUpStatus="Successful";
			response.sendRedirect("./UserLogin.jsp");
		}
		else if(userDetails.getUserId() == null || userDetails.getAddress() == null || userDetails.getEmailId() == null || userDetails.getFirstName() == null || userDetails.getPassword() == null || userDetails.getLastName() == null  )
		{
			//Fill All the details
			//signUpStatus="Failed";
			response.sendRedirect("./EmptySignUpForm.jsp");
		}
		else if (statusUserName == false)

		{
			response.sendRedirect("./ChooseOtherUserName.jsp");
			
			
		}//		catch(SQLException e)
//		{
//			//Choose Different UserName
//			signUpStatus="Failed";
//			response.sendRedirect("./FailedLogin.jsp");
//		}
		
	
	}	
	}


