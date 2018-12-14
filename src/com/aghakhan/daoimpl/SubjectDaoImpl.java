package com.aghakhan.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aghakhan.dao.SubjectDao;
import com.aghakhan.dbcon.DbConnection;

import com.aghakhan.model.Subjects;

public class SubjectDaoImpl implements SubjectDao{
	Connection conn=DbConnection.getDBConnection();
	@Override
	public ArrayList<Subjects> getSubjectsbyId(int id) {
		ArrayList<Subjects> list = new ArrayList<Subjects>();
		try
		{
			String query="SELECT sub.`id`,sub.`name`,c.`name` 'classs',g.`name` 'group',sub.`created_at`,sub.`updated_at` FROM subjects sub INNER JOIN classes c ON c.`id`= sub.`class_id` INNER JOIN `group` g ON g.`id`= sub.`group_id` AND sub.`id`="+id;

			  PreparedStatement pst = conn.prepareStatement(query);
					  
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  	  
						  list.add(new Subjects(rs.getInt("id"), rs.getString("name"), rs.getString("classs"), rs.getString("group"),  rs.getString("created_at"), rs.getString("updated_at")  ));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<Subjects> getSubjects() {
		ArrayList<Subjects> list = new ArrayList<Subjects>();
		try
		{
			String query="SELECT sub.`id`,sub.`name`,c.`name` 'classs',g.`name` 'group',sub.`created_at`,sub.`updated_at` FROM subjects sub INNER JOIN classes c ON c.`id`= sub.`class_id` INNER JOIN `group` g ON g.`id`= sub.`group_id`";

			  PreparedStatement pst = conn.prepareStatement(query);
					  
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  	  
						  	list.add(new Subjects(rs.getInt("id"), rs.getString("name"), rs.getString("classs"), rs.getString("group"),  rs.getString("created_at"), rs.getString("updated_at")  ));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int addSubjects(Subjects u) {
		int i=0;
		try{
			 PreparedStatement pst = conn.prepareStatement("insert into `subjects` (name,class_id,group_id) values(?,?,?)");
		
			 pst.setString(1, u.getName());
			 pst.setInt(2, Integer.parseInt(u.getClasss()));
			 pst.setInt(3, Integer.parseInt(u.getGroup()));
			
			i=pst.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteSubjects(Subjects u) {
		int i=0;
		try
		{
			String query = "DELETE FROM `subjects` WHERE id = ?" ;
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
	public int updateSubjects(Subjects u) {
		int i=0;
		try
		{
			String query = "UPDATE 	`subjects` SET name =?,class_id=?,group_id=?  WHERE id = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getName());
			 ps.setInt(2, Integer.parseInt(u.getClasss()));
			 ps.setInt(3, Integer.parseInt(u.getGroup()));
			
			
	
			
			
			ps.setInt(4, u.getId());
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public ArrayList<Subjects> getNineClassSubjects(String group) {
		ArrayList<Subjects> list = new ArrayList<Subjects>();
		try
		{
			String query="SELECT sub.`id`,sub.`name`,c.`name`  'classs',g.`name` 'group',sub.`created_at`,sub.`updated_at` FROM subjects sub INNER JOIN classes c ON c.`id`= sub.`class_id` INNER JOIN `group` g ON g.`id`= sub.`group_id` WHERE c.name='9th' AND g.`name`='"+group+"';  "; 

			  PreparedStatement pst = conn.prepareStatement(query);
					  
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  	  
						  list.add(new Subjects(rs.getInt("id"), rs.getString("name"), rs.getString("classs"), rs.getString("group"),  rs.getString("created_at"), rs.getString("updated_at")  ));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<Subjects> getElevanClassSubjects(String group) {
		ArrayList<Subjects> list = new ArrayList<Subjects>();
		try
		{
			String query="SELECT sub.`id`,sub.`name`,c.`name`  'classs',g.`name` 'group',sub.`created_at`,sub.`updated_at` FROM subjects sub INNER JOIN classes c ON c.`id`= sub.`class_id` INNER JOIN `group` g ON g.`id`= sub.`group_id` WHERE c.name='1st year' AND g.`name`='"+group+"'; "; 

			  PreparedStatement pst = conn.prepareStatement(query);
					  
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  	  
						  list.add(new Subjects(rs.getInt("id"), rs.getString("name"), rs.getString("classs"), rs.getString("group"),  rs.getString("created_at"), rs.getString("updated_at")  ));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getTotal() {
		int total = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS total FROM subjects");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				total = rs.getInt("total");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return total;
	}
	

}
