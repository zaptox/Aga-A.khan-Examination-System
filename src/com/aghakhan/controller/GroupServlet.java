package com.aghakhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.aghakhan.dao.GroupDao;

import com.aghakhan.daoimpl.GroupDaoImpl;

import com.aghakhan.model.Group;

/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/GroupServlet")
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (	request.getParameter("name")!=null &&
				
				request.getParameter("id")!=null){
				
				int id =Integer.parseInt(request.getParameter("id"));
				String name =request.getParameter("name");
				
				Group g = new Group();
				g.setId(id);
				g.setName(name);
		
				GroupDao cd = new GroupDaoImpl();
				cd.updateGroup(g);
				response.sendRedirect("viewgroup.jsp");
			
		}
		else{
			System.out.println("Not Work");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (	request.getParameter("name")!=null 
				){
			
				String name =request.getParameter("name");
				
				Group g = new Group();
				g.setName(name);
				GroupDao cd = new GroupDaoImpl();
				cd.addGroup(g);
				response.sendRedirect("viewgroup.jsp");
			
		}
		else{
			System.out.println("Not Work");
		}
	}

}
