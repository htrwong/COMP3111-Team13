package atu_system.inquiry_website;

import java.io.IOException;
import java.io.PrintWriter;

import atu_system.inquiry_website.InquirySystem.InquiryResult;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class InquiryServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Forward request to index.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, res);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Get student ID
		String studentID = req.getParameter("id");
	  
		// Get data output according to student ID
		try {
			InquiryResult result = InquirySystem.inquire(studentID);
			
			if (result.success) {
				// Attach result to request
				req.setAttribute("inquiry-result", result);
			  
				// Forward request to result.jsp
				RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
				rd.forward(req, res);
			} else {
				// Forward request to 404.jsp
				RequestDispatcher rd = req.getRequestDispatcher("/404.jsp");
				rd.forward(req, res);
			}
		} catch (Exception e) {
			// Forward request to 404.jsp
			RequestDispatcher rd = req.getRequestDispatcher("/404.jsp");
			rd.forward(req, res);
		}
	  
		
	  
	}

}