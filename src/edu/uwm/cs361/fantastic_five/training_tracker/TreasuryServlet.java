package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TreasuryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>Treasury</h1>");
		resp.getWriter().println("<h2><a href='treasury/program'>View Income By Program</a></h2>");
		resp.getWriter().println("<h2><a href=''> View Income By Student</a></h2>");
		resp.getWriter().println("<h2><a href=''> View Income By Instructor</a></h2>");
		resp.getWriter().println("<br><a href='/homepage'> Home</a>");
		resp.getWriter().println("<a href='/logout'> Log Out</a>");
	}
}
