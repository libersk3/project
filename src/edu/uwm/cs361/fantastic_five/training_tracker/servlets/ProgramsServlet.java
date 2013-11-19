package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;

@SuppressWarnings("serial")
public class ProgramsServlet extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = getPersistenceManager();

		req.setAttribute("programs", pm.newQuery(Program.class).execute());

		forwardToJsp("programs.jsp", req, resp);
	}
}
