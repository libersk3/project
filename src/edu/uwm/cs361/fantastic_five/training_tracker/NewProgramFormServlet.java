package edu.uwm.cs361.fantastic_five.training_tracker;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;

@SuppressWarnings("serial")
public class NewProgramFormServlet extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		forwardToJsp("new_program_form.jsp", req, resp);
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
}
