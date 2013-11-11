package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import java.util.List;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class StudentsServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = getPersistenceManager();
		
		resp.setContentType("text/html");

		resp.getWriter().println("<h1>List of Students: </h1>");
		resp.getWriter().println("<br />");
		resp.getWriter().println("<ul>");
		for (Student student : (List<Student>) pm.newQuery(Student.class).execute()) {
			resp.getWriter().println(student.getFirstName()+ " ");
			resp.getWriter().println(student.getLastName());
			resp.getWriter().println("<br/>");
		}
		resp.getWriter().println("<hr/>");
		resp.getWriter().println("<br />");
		resp.getWriter().println("<a href='students/new'>Create Student</a>");
	}

	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
	
} //end class
