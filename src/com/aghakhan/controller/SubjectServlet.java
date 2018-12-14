package com.aghakhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aghakhan.dao.GroupDao;
import com.aghakhan.dao.SubjectDao;
import com.aghakhan.daoimpl.GroupDaoImpl;
import com.aghakhan.daoimpl.SubjectDaoImpl;
import com.aghakhan.model.Group;
import com.aghakhan.model.Subjects;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (	request.getParameter("subject")!=null &&
				request.getParameter("classs")!=null &&
				request.getParameter("group")!=null && 
				request.getParameter("id")!=null
				){
				
				int id =Integer.parseInt(request.getParameter("id"));
				String name =request.getParameter("subject");	
				String classs =request.getParameter("classs");
				String group =request.getParameter("group");
				
				Subjects sub= new Subjects();
				sub.setId(id);
				sub.setName(name);
				sub.setClasss(classs);
				sub.setGroup(group);
			SubjectDao cd = new SubjectDaoImpl();
				cd.updateSubjects(sub);
				response.sendRedirect("viewsubjects.jsp");
			
		}
		else{
			System.out.println("Not Work");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (	request.getParameter("subject")!=null &&
				request.getParameter("classs")!=null &&
				request.getParameter("group")!=null 
				){
			
				String name =request.getParameter("subject");
				String classs =request.getParameter("classs");
				String group =request.getParameter("group");
				
				Subjects sub= new Subjects();
				sub.setName(name);
				sub.setClasss(classs);
				sub.setGroup(group);
			SubjectDao cd = new SubjectDaoImpl();
				cd.addSubjects(sub);
				response.sendRedirect("viewsubjects.jsp");
			
		}
		else{
			System.out.println("Not Work");
		}
	}

}
