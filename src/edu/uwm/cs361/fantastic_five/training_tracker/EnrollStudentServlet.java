package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.List;
import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class EnrollStudentServlet extends BaseServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = getPersistenceManager();
		req.setAttribute("enroll_student", pm.newQuery(Student.class).execute());

		String key = req.getParameter("id");
		long keyLong = Long.parseLong(key);
		Program program = pm.getObjectById(Program.class, keyLong);

		req.setAttribute("program", pm.getObjectById(Program.class, keyLong));

		List<Student> programStudents = (List<Student>)pm.newQuery(Student.class).execute();
		ArrayList<Student> studentList = new ArrayList<Student>(programStudents);
		studentList.removeAll(program.listStudents());

		req.setAttribute("StudentsList", studentList);
		forwardToJsp("enroll_student.jsp", req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PersistenceManager pm = getPersistenceManager();
		String studentKey = req.getParameter("student");
		if (studentKey == null) {
			resp.setContentType("text/html");

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
}
