package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class HomepageServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		resp.getWriter().println("<h1><a href='/programs'>PROGRAMS</a><h1>");
		resp.getWriter().println("<h1><a href='/students'>STUDENTS</a><h1>");
		resp.getWriter().println("<br><h2><a href='/login' method='GET'>Log Out</a><h2>");
	}
}
