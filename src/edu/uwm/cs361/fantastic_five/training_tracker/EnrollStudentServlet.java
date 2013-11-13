package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import java.util.List;
import java.util.Set;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class EnrollStudentServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = getPersistenceManager();
		
		String key = req.getParameter("id");
		long keyLong = Long.parseLong(key);
		
		Program program = pm.getObjectById(Program.class, keyLong);
		
		if (program != null) {
			resp.setContentType("text/html");
			resp.getWriter().println("<h1> Enroll Student in " + program.getName() + ":</h1>");
			resp.getWriter().println("<ul>");
			Set<Student> programStudents = program.listStudents();
			boolean found = false;
			resp.getWriter().println("<form action='' method = 'POST'>");
			for (Student student : (List<Student>) pm.newQuery(Student.class).execute()){
				for (Student s : programStudents)
				{
					if (student == s)
						found = true;
				}
				if (!found)
					resp.getWriter().println("<br><input type='radio' name='student' value='"+student.getKey().getId()+"'>" + student.getFirstName() + " " + student.getLastName());
				found = false;
			}
		}
		resp.getWriter().println("<br><input type='submit' value='Enroll Student'>");
		resp.getWriter().println("</form>");
		resp.getWriter().println("</ul>");

		resp.getWriter().println("<br><br><a href='/homepage'>Home</a>");
		resp.getWriter().println("<a href='/logout'>Log Out</a>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{	
		PersistenceManager pm = getPersistenceManager();
		String studentKey = req.getParameter("student");
		if (studentKey == null) {
			resp.getWriter().println("<h3>Error: No student selected</h3>");
			resp.getWriter().println("<form action='/programs'>");
			resp.getWriter().println("<input type='submit' value='Back to Programs Page'>");
			resp.getWriter().println("</form>");
		}
		else {
			long studentKeyLong = Long.parseLong(studentKey);
			String key = req.getParameter("id");
			long keyLong = Long.parseLong(key);
			
			Program program = pm.getObjectById(Program.class,keyLong);
			Student student = pm.getObjectById(Student.class,studentKeyLong);
			program.addStudent(student);
			
			resp.sendRedirect("/programs");
		}
	}
	
	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
}
