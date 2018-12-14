package com.aghakhan.dao;

import java.util.ArrayList;

import com.aghakhan.model.Students;

public interface StudentDao {
		
	public ArrayList<Students> getStudentbyRollno(String rollno);
	public ArrayList<Students> getStudentbyId(int id);	
	public ArrayList<Students> getStudent();	
	public int addStudent(Students u);
	public int deleteStudent(Students u);
	public int updateStudent(Students  u);
	
	
	public String getStudentImageId(int id);
	
	public int getTotalStudent();

}
