package com.aghakhan.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.aghakhan.dao.StudentDao;
import com.aghakhan.daoimpl.StudentDaoImpl;
import com.aghakhan.model.Students;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 private final String UPLOAD_DIRECTORY = "F:/agakhan/students/images";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String updated_at = simpleDateFormat.format(new Date());


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
                         System.out.println("Updated Image: "+name);
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                    else{
                    	if(item.getFieldName().equals("name")){
                    		//userBean.setEmail(item.getString());
                    		std.setName(item.getString());
                    		
                    		
                    	}
                    	if(item.getFieldName().equals("father_name")){
                    		//userBean.setEmail(item.getString());
                    		std.setFather(item.getString());
                    		
                    		
                    	}
                    		if(item.getFieldName().equals("cast")){
                    		//userBean.setEmail(item.getString());
                    		std.setCast(item.getString());
                    		
                    		
                    	}
                    			
                    	if(item.getFieldName().equals("age")){
                    		//userBean.setEmail(item.getString());
                    		std.setAge(Integer.parseInt(item.getString()));
                    		
                    		
                    	}
                    	
                    	
                    	if(item.getFieldName().equals("nic")){
                    		//userBean.setEmail(item.getString());
                    		std.setNic(item.getString());
                    		
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("dob")){
                    		//userBean.setEmail(item.getString());
                    		std.setDob(item.getString());
                    		
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("religion")){
                    		//userBean.setEmail(item.getString());
                    		std.setReligion(item.getString());
                    		
                    		
                    	}
                    	if(item.getFieldName().equals("contact")){
                    		//userBean.setEmail(item.getString());
                    		std.setContact(item.getString());
                    		
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("group")){
                    		//userBean.setEmail(item.getString());
                    		std.setGroup(item.getString());
                    		
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("classs")){
                    		//userBean.setEmail(item.getString());
                    		std.setClasss(item.getString());
                    		
                    		
                    	}
                    	if(item.getFieldName().equals("seatno")){
                    		//userBean.setEmail(item.getString());
                    		std.setSeatno(item.getString());
                    		
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("id")){
                    		//userBean.setEmail(item.getString());
                    		std.setId(Integer.parseInt(item.getString()));
                    		
                    		
                    	}
                    	std.setUpdated_at(updated_at);
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
           }
        	System.out.println(name);
        	std.setPicture(name);
        //	sdao.(std);
        	
        	sdao.updateStudent(std);
        	
            response.sendRedirect("viewstudents.jsp");
        	
        	
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
            
            
            
            System.out.println("Else work");
        }
	}

}
