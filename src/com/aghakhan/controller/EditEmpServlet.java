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

import com.aghakhan.dao.EmployeeDao;
import com.aghakhan.daoimpl.EmployeeDaoImpl;
import com.aghakhan.model.Employee;

/**
 * Servlet implementation class EditEmpServlet
 */
@WebServlet("/EditEmpServlet")
public class EditEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpServlet() {
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
	 private final String UPLOAD_DIRECTORY = "F:/agakhan/employee/images";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String updated_at = simpleDateFormat.format(new Date());

		
		
		EmployeeDao edao=new EmployeeDaoImpl();
		Employee emp1= new Employee();
        if(ServletFileUpload.isMultipartContent(request))
        {
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
                    		emp1.setName(item.getString());
                    		System.out.println("Name: "+ item.getString());
                    		
                    	}
                    	
                    	if(item.getFieldName().equals("password")){
                    		//userBean.setEmail(item.getString());
                    		emp1.setPassword(item.getString());
                    		System.out.println("Password: "+ item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("contact")){
                    		//userBean.setEmail(item.getString());
                    		emp1.setContact(item.getString());
                    		System.out.println("contact: "+ item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("dob")){
                    		//userBean.setEmail(item.getString());
                    		emp1.setDob(item.getString());
                    		System.out.println("dob: "+ item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("gender")){
                    		//userBean.setEmail(item.getString());
                    		emp1.setGender(item.getString());
                    		System.out.println("gender: "+ item.getString());
                    		
                    	}
                    	if(item.getFieldName().equals("id")){
                    		//userBean.setEmail(item.getString());
                    		emp1.setId(Integer.parseInt(item.getString()));
                    		System.out.println("id: "+ Integer.parseInt(item.getString()));
                    		
                    	}
                    	   
                    	         	emp1.setUpdated_at(updated_at);
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
           }
        	
        	emp1.setPicture(name);
        	edao.updateEmployee(emp1);
        	
        	
        	
            response.sendRedirect("viewemployees.jsp");
         
        }else{
            request.setAttribute("message","Sorry this Servlet only handles file upload request");
            
            System.out.println("EditEmployee without photo ");
        }
	}

}
