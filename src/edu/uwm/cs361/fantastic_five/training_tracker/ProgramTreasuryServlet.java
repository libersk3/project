package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;

@SuppressWarnings("serial")
public class ProgramTreasuryServlet extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PersistenceManager pm = getPersistenceManager();
		
		resp.setContentType("text/html");
		resp.getWriter().println("<table width='500' border='1'>");
		resp.getWriter().println("<caption><h1>Revenue By Program</h1></caption>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td><h2><u><b>Program</b></u><h2></td>");
		resp.getWriter().println("<td><h2><u><b>Revenue</b></u><h2></td>");
		resp.getWriter().println("</tr>");
		for (Program program : (List<Program>) pm.newQuery(Program.class).execute()) {
			double amount = program.getPrice() * program.listStudents().size();
			
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td><h3>" + program.getName() + "</h3></td>");
			resp.getWriter().println("<td><h3> $" + Double.toString(amount) + "</h3></td>");
			resp.getWriter().println("</tr>");
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println("</table>");
		resp.getWriter().println("<br><br><a href='/homepage'>Home</a>");
		resp.getWriter().println("<a href='/logout'>Log Out</a>");
	}

	
	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
}
