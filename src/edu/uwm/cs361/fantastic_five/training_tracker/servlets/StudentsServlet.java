package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;

@SuppressWarnings("serial")
public class StudentsServlet extends BaseServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = getPersistenceManager();

		req.setAttribute("students", pm.newQuery(Student.class).execute());

		forwardToJsp("students.jsp", req, resp);
	}
} //end class
