package com.aghakhan.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aghakhan.dao.StudentDao;
import com.aghakhan.dbcon.DbConnection;
import com.aghakhan.model.Students;
import com.aghakhan.model.User;

public class StudentDaoImpl implements StudentDao {
	Connection conn=DbConnection.getDBConnection();
	@Override
	public ArrayList<Students> getStudentbyId(int id) {
		ArrayList<Students> list = new ArrayList<Students>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("SELECT s.`id`,s.`name` ,s.`father`  ,s.nic,s.`age` ,s.`cast`,s.`contact`,s.`dob`,s.`religion`,s.`picture`,s.`seatno`,s.`created_at`,s.`updated_at`,c.`name` AS 'classs' ,g.`name` AS 'group' FROM students s INNER JOIN classes c ON s.`classs_id` =c.`id` INNER JOIN `group` g ON s.`group_id` =g.`id` WHERE s.id="+id +" AND s.status=1" );
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  
						  list.add(new Students(rs.getInt("id"), rs.getString("name"), rs.getString("father"), rs.getString("cast"), rs.getInt("age"), rs.getString("picture"), rs.getString("nic"), rs.getString("dob"), rs.getString("contact"), rs.getString("religion"), rs.getString("seatno"),rs.getString("created_at") ,rs.getString("updated_at"),rs.getString("classs"),rs.getString("group")  ));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<Students> getStudent() {
		ArrayList<Students> list = new ArrayList<Students>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("SELECT s.`id`,s.`name` ,s.`father`  ,s.nic,s.`age` ,s.`cast`,s.`contact`,s.`dob`,s.`religion`,s.`picture`,s.`seatno`,s.`created_at`,s.`updated_at`,c.`name` AS 'classs' ,g.`name` AS 'group' FROM students s INNER JOIN classes c ON s.`classs_id` =c.`id` INNER JOIN `group` g ON s.`group_id` =g.`id`  AND s.status=1");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  
list.add(new Students(rs.getInt("id"), rs.getString("name"), rs.getString("father"), rs.getString("cast"), rs.getInt("age"), rs.getString("picture"), rs.getString("nic"), rs.getString("dob"), rs.getString("contact"), rs.getString("religion"), rs.getString("seatno"),rs.getString("created_at") ,rs.getString("updated_at"),rs.getString("classs"),rs.getString("group")  ));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int addStudent(Students s) {
		int i=0;
		try{
		
		String query="INSERT INTO `aghakhan`.`students` (`name`, `father`, `cast`, `age`, `picture`, `nic`, `dob`, `contact`, `religion`, `seatno`, `created_at`,classs_id,group_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,s.getName());
		ps.setString(2, s.getFather());
		ps.setString(3, s.getCast());
		ps.setInt(4, s.getAge());
		ps.setString(5, s.getPicture());
		ps.setString(6, s.getNic());
		ps.setString(7, s.getDob());
		ps.setString(8, s.getContact());
		ps.setString(9, s.getReligion());
		ps.setString(10, s.getSeatno());
		ps.setString(11, s.getCreated_at());
		ps.setString(12, s.getClasss());
		ps.setString(13, s.getGroup());
		
		//ps.setInt(12, Integer.parseInt(s.getClasss()));
		//ps.setInt(13, Integer.parseInt(s.getGroup()));
		
		
		
	
		i=ps.executeUpdate();
		}catch(Exception e){}
		
		return i;
	}

	@Override
	public int deleteStudent(Students u) {
		int i=0;
		try
		{
			String query = "UPDATE 	`students` SET status =0  WHERE id = ? " ;
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
	public int updateStudent(Students u) {
		int i=0;
		try
		{
			String query = "UPDATE students SET `name` = ? , `father` = ? , `cast` = ? , `age` = ? , `picture` = ? , `nic` = ? , `dob` = ? , `contact` = ? , `religion` = ? , `seatno` = ? , `updated_at` = ? , `group_id` = ? , `classs_id` = ? WHERE `id` = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getFather());
			ps.setString(3, u.getCast());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getPicture());
			ps.setString(6, u.getNic());
			ps.setString(7, u.getDob());
			ps.setString(8, u.getContact());
			ps.setString(9, u.getReligion());
			
			ps.setString(10, u.getSeatno());
			ps.setString(11, u.getUpdated_at());
			
			
			
			ps.setString(12, u.getGroup());
			ps.setString(13, u.getClasss());
			ps.setInt(14, u.getId());
			
			
	
			
			
			ps.setInt(4, u.getId());
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public ArrayList<Students> getStudentbyRollno(String rollno) {
		ArrayList<Students> list = new ArrayList<Students>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("SELECT s.`id`,s.`name` ,s.`father`  ,s.nic,s.`age` ,s.`cast`,s.`contact`,s.`dob`,s.`religion`,s.`picture`,s.`seatno`,s.`created_at`,s.`updated_at`,c.`name` AS 'classs' ,g.`name` AS 'group' ,sub.`name` AS 'subjects'FROM students s INNER JOIN classes c ON s.`classs_id` =c.`id` INNER JOIN `group` g ON s.`group_id` =g.`id`INNER JOIN subjects sub ON sub.`class_id`= s.`classs_id`WHERE s.`group_id` = sub.`group_id` AND s.`seatno` = '"+rollno+"'");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  
list.add(new Students(rs.getInt("id"), rs.getString("name"), rs.getString("father"), rs.getString("cast"), rs.getInt("age"), rs.getString("picture"), rs.getString("nic"), rs.getString("dob"), rs.getString("contact"), rs.getString("religion"), rs.getString("seatno"),rs.getString("created_at") ,rs.getString("updated_at"),rs.getString("classs"),rs.getString("group"),rs.getString("subjects")  ));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String getStudentImageId(int id) {
		String img="";
				
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("SELECT picture FROM students WHERE id ="+id);
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  
						  img = rs.getString("picture");
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return img;
			
	}

	@Override
	public int getTotalStudent() {
		int total=0;
		
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("SELECT COUNT(*) AS total FROM students WHERE STATUS=1");
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
