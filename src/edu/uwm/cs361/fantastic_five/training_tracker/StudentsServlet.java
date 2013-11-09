package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import java.util.List;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class StudentsServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = getPersistenceManager();
		
		resp.setContentType("text/html");

		resp.getWriter().println("<ul>");
		for (Program program : (List<Program>) pm.newQuery(Program.class).execute()) {
			resp.getWriter().println(program.getName());
			resp.getWriter().println("<br/>");
			resp.getWriter().println(program.getInstructor());
			resp.getWriter().println("<br/>");
			resp.getWriter().println(program.getPrice());
			resp.getWriter().println("<br/>");
			resp.getWriter().println("<hr/>");
		}
		resp.getWriter().println("<a href='programs/new'>New Program</a>");
	}

	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
	
} //end class
