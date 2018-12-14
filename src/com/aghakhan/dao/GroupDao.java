package com.aghakhan.dao;

import java.util.ArrayList;

import com.aghakhan.model.Group;

public interface GroupDao {
	public ArrayList<Group> getGroupbyId(int id);	
	public ArrayList<Group> getGroup();	
	public int addGroup(Group u);
	public int deleteGroup(Group u);
	public int updateGroup(Group  u);
	public int getTotal();
}
