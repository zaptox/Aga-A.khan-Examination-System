package com.aghakhan.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aghakhan.dao.StudentDao;
import com.aghakhan.daoimpl.StudentDaoImpl;
import com.aghakhan.model.Students;

/**
 * Servlet implementation class StudentRecordServlet
 */
@WebServlet("/StudentRecordServlet")
public class StudentRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("rollno")!=null){
			String rollno = request.getParameter("rollno");
			response.sendRedirect("showresults.jsp?rollno="+rollno);
			
//			StudentDao dao = new StudentDaoImpl();
//			ArrayList<Students> list= new ArrayList<Students>();
//			dao.getStudentbyRollno(rollno);
			
			
			
			
		}
	}

}
