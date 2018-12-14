package com.aghakhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aghakhan.dao.EmployeeDao;
import com.aghakhan.dao.UserDao;
import com.aghakhan.daoimpl.EmployeeDaoImpl;
import com.aghakhan.daoimpl.UserDaoImpl;
import com.aghakhan.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			if (request.getParameter("name")!=null&&request.getParameter("password")!=null){
				String name=request.getParameter("name");
				String password=request.getParameter("password");
				
				HttpSession login = request.getSession();
				
				
				EmployeeDao dao= new EmployeeDaoImpl();
				if (dao.getLogin(name, password)){
					login.setAttribute("user",name );
					response.sendRedirect("index.jsp?login=success");
				}
				else{
					response.sendRedirect("index.jsp?login=failed");
				}
				
				
				/*
				User u = new User();
				u.setName(name);
				u.setPassword(password);
				
				UserDao ud= new UserDaoImpl();
				if(ud.loginUser(u)){
					login.setAttribute("user",name );
					response.sendRedirect("index.jsp?login=success");
				}else{
					response.sendRedirect("index.jsp?login=failed");
				}
				*/
				
				
				
			}
	}

}
