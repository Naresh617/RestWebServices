package com.apspdcl.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apspdcl.util.DatabaseConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Verification code for user", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String result="";
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		
		try {
			
			 con = DatabaseConnection.initializeDatabase();
			 stmt=con.createStatement();
			 String sql="select * from user";
			 rs = stmt.executeQuery(sql);
			 while(rs.next()){
				 if(uname.equalsIgnoreCase(rs.getString("uname"))&& pwd.equalsIgnoreCase(rs.getString("pwd"))) 
				 {
					 result="success";
				 }
				 
			 }
			 
			 response.getWriter().write(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(stmt !=null)
				{
					stmt.close();
				}
				if(con !=null)
				{
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
