package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class CreateStudentFormServlet extends BaseServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		forwardToJsp("create_student_form.jsp", req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PersistenceManager pm = getPersistenceManager();

		try {
			pm.makePersistent(new Student(
				req.getParameter("first name"),
				req.getParameter("last name"),
				req.getParameter("email")
			));
			resp.sendRedirect("/students");
		} finally {
			pm.close();
		}
	}
} //end class
