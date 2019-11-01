package org.res.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.res.model.bl.ngo.NgoDetailsBl;
import org.res.model.bl.ngo.NgoDetailsBlImpl;



public class CategoryOrInputMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoryOrInputMenuController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		NgoDetailsBl ngoDetailsBl =new NgoDetailsBlImpl();
		List<String> categoryList = ngoDetailsBl.getcategory();
		categoryList.add(0, "None");
		session.setAttribute("categoryList", categoryList);
		response.sendRedirect("./CategoryOrInput.jsp");
		
	}

}
