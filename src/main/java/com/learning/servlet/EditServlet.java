package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
         out.println("<h1>Update Employee</h1>");  
         String sid=request.getParameter("empId");  
         int id=Integer.parseInt(sid);  
           
         Employee e=EmpDao.getEmployeeById(id);  
           
         out.print("<form action='EditServlet2' method='post'>");  
         out.print("<table>");  
         out.print("<tr><td></td><td><input type='hidden' name='empId' value='"+e.getEmpId()+"'/></td></tr>");  
         out.print("<tr><td>Name:</td><td><input type='text' name='Name' value='"+e.getName()+"'/></td></tr>");  
           
         out.print("<tr><td>Department:</td><td><input type='text' name='Dept' value='"+e.getDept()+"'/></td></tr>");  
 
        
         out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
         out.print("</table>");  
         out.print("</form>");  
           
         out.close();  
		
		
		
		
		
		
		
		
	}


}
