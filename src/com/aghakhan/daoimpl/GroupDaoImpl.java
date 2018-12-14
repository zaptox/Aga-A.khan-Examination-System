package com.aghakhan.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aghakhan.dao.GroupDao;
import com.aghakhan.dbcon.DbConnection;

import com.aghakhan.model.Group;

public class GroupDaoImpl implements GroupDao{
	Connection conn=DbConnection.getDBConnection();
	@Override
	public ArrayList<Group> getGroupbyId(int id) {
		ArrayList<Group> list = new ArrayList<Group>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement("Select * from `group` where id="+id);
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						//  System.out.print(rs.getString("name"));
list.add(new Group(rs.getInt("id"), rs.getString("name"),  rs.getString("created_at"), rs.getString("updated_at")));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<Group> getGroup() {
		ArrayList<Group> list = new ArrayList<Group>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement("Select * from `group`");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						 
list.add(new Group(rs.getInt("id"), rs.getString("name"),  rs.getString("created_at"), rs.getString("updated_at")));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int addGroup(Group u) {
		int i=0;
		try{
			 PreparedStatement pst = conn.prepareStatement("insert into 	`group` (name) values(?)");
		
			 pst.setString(1, u.getName());
			
			i=pst.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteGroup(Group u) {
		int i=0;
		try
		{
			String query = "DELETE FROM 	`group` WHERE id = ?" ;
			PreparedStatement ps = conn.prepareStatement(query);
		
			ps.setInt(1,u.getId());
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateGroup(Group u) {
		int i=0;
		try
		{
			String query = "UPDATE 	`group` SET name =?  WHERE id = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getName());
			
	
			
			
			ps.setInt(2, u.getId());
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
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
					  ("SELECT COUNT(*) AS total FROM `group` ");
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
	

}
