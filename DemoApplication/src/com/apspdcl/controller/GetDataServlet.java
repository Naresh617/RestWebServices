package com.apspdcl.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apspdcl.modal.Student;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Student> sl=new ArrayList<>();
			Student s1=new Student("Naresh", 35);
			Student s2=new Student("Rajesh",26);
			Student s3=new Student("Mahesh",36);
			sl.add(s1);
			sl.add(s2);
			sl.add(s3);
			Gson gson = new Gson();
			String json = gson.toJson(sl); 
			
			response.getWriter().write(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
