package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;

@SuppressWarnings("serial")
public class SingleProgramServlet extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = getPersistenceManager();

		String id = req.getParameter("id");
		long idLong = Long.parseLong(id);
		Program program = pm.getObjectById(Program.class, idLong);

		req.setAttribute("program", program);
		if (program != null) req.setAttribute("students", program.listStudents());

		forwardToJsp("program.jsp", req, resp);
	}
}
