package com.aghakhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import java.io.File;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.aghakhan.dao.StudentDao;
import com.aghakhan.daoimpl.StudentDaoImpl;
import com.aghakhan.model.Students;


/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	/*	String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String updated_at = simpleDateFormat.format(new Date());
		
		if(request.getParameter("id")!=null &&
			request.getParameter("name")!=null	&&
			request.getParameter("father_name")!=null	&&
			request.getParameter("cast")!=null	&&
			request.getParameter("age")!=null	&&
			request.getParameter("contact")!=null	&&
			request.getParameter("nic")!=null	&&
			request.getParameter("religion")!=null	&&
			request.getParameter("group")!=null	&&
			request.getParameter("classs")!=null	&&
			request.getParameter("seatno")!=null	
			
				){
			int id =Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String father_name=	request.getParameter("father_name");
			String cast=request.getParameter("cast");
			int age=Integer.parseInt(request.getParameter("age"));
			String contact=request.getParameter("contact");
			String nic=	request.getParameter("nic");
			String religion=request.getParameter("religion");
			String group=	request.getParameter("group");
			String classs=	request.getParameter("classs");
			String seatno=	request.getParameter("seatno");
			
			Students s =new Students();
			s.setId(id);
			s.setName(name);
			s.setFather(father_name);
			s.setCast(cast);
			s.setAge(age);
			s.setContact(contact);
			s.setNic(nic);
			s.setReligion(religion);
			s.setGroup(group);
			s.setClasss(classs);
			
			s.setSeatno(seatno);
			s.setPicture("avatar-male.png");
			s.setDob("2018-12-06");
			s.setUpdated_at(updated_at);
			
			StudentDao dao= new StudentDaoImpl();
			if (dao.updateStudent(s)==1){
				response.sendRedirect("viewstudents.jsp");
				
			}
			else{
				System.out.println("Error");
			}
			
			
		}*/
		
		

	
	
				
		
	}
	 private final String UPLOAD_DIRECTORY = "F:/agakhan/students/images";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String currentdate = simpleDateFormat.format(new Date());


		Students std= new Students();
		StudentDao sdao=new StudentDaoImpl();
        if(ServletFileUpload.isMultipartContent(request)){
           String name="";
        	try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                         name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                    else{
                    	if(item.getFieldName().equals("name")){
                    		//userBean.setEmail(item.getString());
                    		std.setName(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("father_name")){
                    		//userBean.setEmail(item.getString());
                    		std.setFather(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    		if(item.getFieldName().equals("cast")){
                    		//userBean.setEmail(item.getString());
                    		std.setCast(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    			
                    	if(item.getFieldName().equals("age")){
                    		//userBean.setEmail(item.getString());
                    		std.setAge(Integer.parseInt(item.getString()));
                    		System.out.println(item.getString());
                    		
                    	}
                    	
                    	
                    	if(item.getFieldName().equals("nic")){
                    		//userBean.setEmail(item.getString());
                    		std.setNic(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("dob")){
                    		//userBean.setEmail(item.getString());
                    		std.setDob(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("religion")){
                    		//userBean.setEmail(item.getString());
                    		std.setReligion(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("contact")){
                    		//userBean.setEmail(item.getString());
                    		std.setContact(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("group")){
                    		//userBean.setEmail(item.getString());
                    		std.setGroup(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("classs")){
                    		//userBean.setEmail(item.getString());
                    		std.setClasss(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("seatno")){
                    		//userBean.setEmail(item.getString());
                    		std.setSeatno(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("seatno")){
                    		//userBean.setEmail(item.getString());
                    		std.setSeatno(item.getString());
                    		System.out.println(item.getString());
                    		
                    	}
                    	std.setCreated_at(currentdate);
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
           }
        	System.out.println(name);
        	std.setPicture(name);
        	sdao.addStudent(std);
        	
            response.sendRedirect("viewstudents.jsp");
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
	}
	
	
}


