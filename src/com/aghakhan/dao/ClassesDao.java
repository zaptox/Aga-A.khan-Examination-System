package com.aghakhan.dao;

import java.util.ArrayList;

import com.aghakhan.model.Classes;

public interface ClassesDao {
	public ArrayList<Classes> getClassesbyId(int id);	
	public ArrayList<Classes> getClasses();	
	public int addClasses(Classes u);
	public int deleteClasess(Classes u);
	public int updateClasses(Classes  u);
	public int getTotal();

}
