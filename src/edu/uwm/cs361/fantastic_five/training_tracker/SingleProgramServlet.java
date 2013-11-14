package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.util.Set;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class SingleProgramServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = getPersistenceManager();

		String id = req.getParameter("id");
		long idLong = Long.parseLong(id);
		Program program = pm.getObjectById(Program.class, idLong);

		req.setAttribute("program", program);
		if (program != null) req.setAttribute("students", program.listStudents());

		String nextJSP = "/WEB-INF/pages/program.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);
	}

	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
}
