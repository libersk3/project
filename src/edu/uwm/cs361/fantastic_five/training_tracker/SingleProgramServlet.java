package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import java.util.Set;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class SingleProgramServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = getPersistenceManager();
		
		String id = req.getParameter("id");
		long idLong = Long.parseLong(id);
		Program program = pm.getObjectById(Program.class,idLong);
		
		if (program != null) {
			resp.setContentType("text/html");
			resp.getWriter().println("<h1> Enrolled Students in " + program.getName() + ": </h1>");
			resp.getWriter().println("<ul>");
			Set<Student> students = program.listStudents();
			for (Student student : students)
				resp.getWriter().println("<br>" +student.getFirstName() + " " + student.getLastName());
			resp.getWriter().println("</ul>");
			resp.getWriter().println("<a href='/programs/enroll?id="+program.getKey().getId()+"'>Enroll Student</a>");
		}
		resp.getWriter().println("<br><br><a href='/homepage'>Home</a>");
		resp.getWriter().println("<a href='/login' method='GET'>Log Out</a>");
	}

	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
}
