package com.aghakhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aghakhan.dao.ClassesDao;
import com.aghakhan.daoimpl.ClassesDaoImpl;
import com.aghakhan.model.Classes;

/**
 * Servlet implementation class ClassesServlet
 */
@WebServlet("/ClassesServlet")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (	request.getParameter("name")!=null &&
				request.getParameter("type")!=null &&
				request.getParameter("id")!=null){
				
				int id =Integer.parseInt(request.getParameter("id"));
				String name =request.getParameter("name");
				String type =request.getParameter("type");
				Classes c = new Classes();
				c.setId(id);
				c.setName(name);
				c.setType(type);
				ClassesDao cd = new ClassesDaoImpl();
				cd.updateClasses(c);
				response.sendRedirect("viewclasses.jsp");
			
		}
		else{
			System.out.println("Not Work");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (	request.getParameter("name")!=null &&
				request.getParameter("type")!=null){
			
				String name =request.getParameter("name");
				String type =request.getParameter("type");
				Classes c = new Classes();
				c.setName(name);
				c.setType(type);
				ClassesDao cd = new ClassesDaoImpl();
				cd.addClasses(c);
				response.sendRedirect("viewclasses.jsp");
			
		}
		else{
			System.out.println("Not Work");
		}
	}

}
