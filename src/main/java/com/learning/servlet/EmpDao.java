package com.learning.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:C:/Users/Atul/eclipse-workspace/CDAC/ServletExampleCDAC/src/main/java/com/learning/servlet/TestDB.db");
			
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return con;
		
	}
	
	public static int save(Employee e) {
		int status = 0;
		
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into Employee(Name, Dept) values(?, ?)"
					);
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getDept());
			
			status = ps.executeUpdate();
			con.close();			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
		
	}
	
	
	public static List<Employee> getAllEmployees(){
		
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDept(rs.getString(3));
				
				list.add(e);
				
			}
			con.close();		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public static int update(Employee e) {
		int status = 0;
		Connection con;
		
		try {
			 con = EmpDao.getConnection();
			
			PreparedStatement ps = con.prepareStatement("update Employee set Name = ?, Dept = ? where EmpId = ?");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getDept());
			ps.setInt(3, e.getEmpId());
			
			
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			
		}
		return status;
		
	}
	
	public static Employee getEmployeeById(int EmpId) {
		 Employee e=new Employee();  
         
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Employee where EmpId=?");  
	            ps.setInt(1,EmpId);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setEmpId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setDept(rs.getString(3));  
	                
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
		
		
		
	}
	
	public static int delete(int EmpId){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Employee where EmpId=?");  
            ps.setInt(1,EmpId);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
	
	

}
