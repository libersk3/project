package edu.uwm.cs361.fantastic_five.training_tracker;
import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;

@SuppressWarnings("serial")
public class NewProgramFormServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String nextJSP = "/WEB-INF/pages/new_program_form.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PersistenceManager pm = getPersistenceManager();

		try {
			pm.makePersistent(new Program(
				req.getParameter("name"),
				req.getParameter("instructor"),
				Double.parseDouble(req.getParameter("price"))
			));
			resp.sendRedirect("/programs");
		} finally {
			pm.close();
		}
	}
	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
}
