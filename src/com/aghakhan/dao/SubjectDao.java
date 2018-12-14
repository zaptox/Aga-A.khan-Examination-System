package com.aghakhan.dao;

import java.util.ArrayList;

import com.aghakhan.model.Subjects;;

public interface SubjectDao {
	public ArrayList<Subjects> getSubjectsbyId(int id);	
	public ArrayList<Subjects> getSubjects();	
	public int addSubjects(Subjects u);
	public int deleteSubjects(Subjects u);
	public int updateSubjects(Subjects  u);
	
	public ArrayList<Subjects> getNineClassSubjects(String group);
	public ArrayList<Subjects> getElevanClassSubjects(String group);
	public int getTotal();
	
	
	
}
