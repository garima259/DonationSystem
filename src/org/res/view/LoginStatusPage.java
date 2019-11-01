package org.res.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginStatusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginStatusPage() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println( "<head><title>LoginStatusPage</title></head>");
		pw.println("<body><h1>"+request.getParameter("loginStatus")+"</h1></body>");
		pw.println("</html>");
		
		
	}

}
