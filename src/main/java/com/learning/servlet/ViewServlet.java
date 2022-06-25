package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<a href = 'index.html'>Add new Employee</a>");
		out.println("<h1> Employee List</h1>");
		
		List<Employee> list = EmpDao.getAllEmployees();
		
		out.println("<table border='1' width='100%'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Department</th><th>Edit</th><th>Delete</th></tr>");
		
		for(Employee e:list) {
			out.println("<tr><td>" + e.getEmpId() + "</td><td>" + 
					e.getName() + "</td><td>" + e.getDept() + "</td>"
							+ "<td><a href='EditServlet?empId=" + e.getEmpId() 
							+ "'>Edit</a></td>"
							+ "<td><a href='DeleteServlet?empId=" + e.getEmpId() 
							+ "'>Delete</a></td>"
							+ "</tr>");
			
		}
		
		out.println("</table>");
		
		out.close();
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
