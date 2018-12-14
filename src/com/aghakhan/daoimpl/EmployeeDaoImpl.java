package com.aghakhan.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aghakhan.dao.EmployeeDao;
import com.aghakhan.dbcon.DbConnection;

import com.aghakhan.model.Employee;

public class EmployeeDaoImpl  implements EmployeeDao{
	Connection conn=DbConnection.getDBConnection();
	@Override
	public ArrayList<Employee> getEmployeebyId(int id) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement("Select * from employees where status=1 AND  id="+id);
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						//  System.out.print(rs.getString("name"));
list.add(new Employee( rs.getInt("id"), rs.getString("picture") , rs.getString("name"),rs.getString("password"), rs.getString("dob"), rs.getString("gender"), rs.getString("contact"),rs.getString("created_at"), rs.getString("updated_at")));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement("Select * from employees where status=1");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						//  System.out.print(rs.getString("name"));
						 list.add(new Employee( rs.getInt("id"), rs.getString("picture") , rs.getString("name"),rs.getString("password"), rs.getString("dob"), rs.getString("gender"), rs.getString("contact"),rs.getString("created_at"), rs.getString("updated_at")));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public int deleteEmployee(Employee u) {
		int i=0;
		try
		{
			String query = "UPDATE 	`employees` SET status =0  WHERE id = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
	
			ps.setInt(1, u.getId());
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateEmployee(Employee u) {
		int i=0;
		try
		{
			String query = "UPDATE `employees` SET `picture` = ? , `name` = ? , `password` = ? , `contact` = ? , `dob` = ? , `gender` = ? , `updated_at` = ? WHERE `id` = ?;  " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getPicture());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getContact());
			ps.setString(5, u.getDob());
			ps.setString(6, u.getGender());
			ps.setString(7, u.getUpdated_at());
			//ps.setString(7, "2018-12-09");
			ps.setInt(8, u.getId());
			
	
			
			
			
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Yahan error hai"+e.getMessage());
			
		}
		return i;
	}

	@Override
	public int addEmployee(Employee u) {
		int i=0;
		try{
			 PreparedStatement pst = conn.prepareStatement("INSERT INTO `aghakhan`.`employees` (`id`, `picture`, `name`, `password`, `contact`, `dob`, `gender`, `created_at`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?); ");
		
			 pst.setString(1, u.getPicture());
			 pst.setString(2, u.getName());
			 pst.setString(3, u.getPassword());
			 pst.setString(4, u.getContact());
			 pst.setString(5, u.getDob());
			 pst.setString(6, u.getGender());
			 pst.setString(7, u.getCreated_at());
			 
			
			i=pst.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		}
		return i;
	}

	@Override
	public int getTotal() {
int total=0;
		
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("SELECT COUNT(*) AS total FROM employees WHERE STATUS=1");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  
						  total = rs.getInt("total");
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
	}

	@Override
	public boolean getLogin(String name, String password) {
		boolean chk = false;
		try
		{
			  PreparedStatement pst = conn.prepareStatement("Select * from employees where name='"+name+"' AND password='"+password+"' AND status=1 ");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						chk=true;
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return chk;
	}

}
