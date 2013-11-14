package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class StudentsServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = getPersistenceManager();

		req.setAttribute("students", pm.newQuery(Student.class).execute());

		String nextJSP = "/WEB-INF/pages/students.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);
	}

	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}

} //end class
