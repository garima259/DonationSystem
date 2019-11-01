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

public class CategoryOrInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryOrInputController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		NgoDetailsBl ngoDetailsBl = new NgoDetailsBlImpl();
		String categoryName = request.getParameter("categoryList");
		String ngoName = request.getParameter("ngoName");
		String ngoId = "";
		if (categoryName.equals("None") && !(ngoName == "")) {
			ngoId = ngoDetailsBl.getNgoId(ngoName);
			session.setAttribute("ngoName", ngoName);
			session.setAttribute("ngoId", ngoId);
			boolean status = ngoDetailsBl.ngoExists(ngoName);
			if (status) {
				response.sendRedirect("./DonationDetails.jsp");
			} else {
				response.sendRedirect("./NgoDoesNotExist.jsp");
			}

		}

		else if ((categoryName.equals("None")) && ngoName == "") {
			response.sendRedirect("./PleaseSelectOne.jsp");
		}

		else if (!(categoryName.equals("None")) && ngoName == "") {
			List<String> ngoList = ngoDetailsBl.getRecordByCategory(categoryName);
			session.setAttribute("ngoList", ngoList);
			response.sendRedirect("./NgoByCategoryMenu.jsp");
		}

		else {
			response.sendRedirect("./PleaseSelectOne.jsp");
			// Please choose 1 thing
		}
	}

}
