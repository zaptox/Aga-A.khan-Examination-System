package com.aghakhan.dao;

import java.util.ArrayList;

import com.aghakhan.model.Employee;;

public interface EmployeeDao {
	public ArrayList<Employee> getEmployeebyId(int id);	
	public ArrayList<Employee> getEmployees();	
	public int addEmployee(Employee u);
	public int deleteEmployee(Employee u);
	public int updateEmployee(Employee  u);
	
	public int getTotal();
	public boolean getLogin(String name,String password);
	
}
