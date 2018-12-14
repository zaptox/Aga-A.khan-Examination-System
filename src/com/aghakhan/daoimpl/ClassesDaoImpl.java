package com.aghakhan.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aghakhan.dao.ClassesDao;
import com.aghakhan.dbcon.DbConnection;
import com.aghakhan.model.Classes;
import com.aghakhan.model.Students;

public class ClassesDaoImpl implements ClassesDao{
	Connection conn=DbConnection.getDBConnection();

	@Override
	public ArrayList<Classes> getClassesbyId(int id) {
		ArrayList<Classes> list = new ArrayList<Classes>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement("Select * from classes where id="+id);
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						//  System.out.print(rs.getString("name"));
list.add(new Classes(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getString("created_at"), rs.getString("updated_at")));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<Classes> getClasses() {
		ArrayList<Classes> list = new ArrayList<Classes>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement("Select * from classes");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						  System.out.print(rs.getString("name"));
list.add(new Classes(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getString("created_at"), rs.getString("updated_at")));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int addClasses(Classes u) {
		int i=0;
		try{
			 PreparedStatement pst = conn.prepareStatement("insert into classes (name,type) values(?,?)");
		
			 pst.setString(1, u.getName());
			 pst.setString(2, u.getType());
			i=pst.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteClasess(Classes u) {
		int i=0;
		try
		{
			String query = "DELETE FROM classes WHERE id = ?" ;
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
	public int updateClasses(Classes u) {
		int i=0;
		try
		{
			String query = "UPDATE classes SET name =? , type =?  WHERE id = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getType());
	
			
			
			ps.setInt(3, u.getId());
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public int getTotal() {
		int total = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS total FROM classes");
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
