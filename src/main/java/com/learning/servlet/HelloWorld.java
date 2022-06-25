package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
		 * 
		 * out.println("<html><body>"); out.println("<h3>Hello World</h3>");
		 * out.println("</body></html>");
		 */
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Title = "Using GET method to read data";
		
		String docType = "<!DOCTYPE HTML>";
		
		out.println(docType + 
				"<html> \n" + 
				"<head><title>" + Title + "</title><head>\n" + 
				"<body bgcolor = \"#f0f0f0\">\n" + 
				"<ul> \n" + 
				"<li><b> First Name</b>: " + 
				request.getParameter("first_name") + "\n" + 
				"</li> <li><b> Last Name</b>: " +
				request.getParameter("last_name") + "\n" + 
				"</ul> \n" + "</body></html>"
				
				);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
