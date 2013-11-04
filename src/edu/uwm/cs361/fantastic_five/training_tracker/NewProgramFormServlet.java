package edu.uwm.cs361.fantastic_five.training_tracker;
import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;


import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;

@SuppressWarnings("serial")
public class NewProgramFormServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		
		resp.setContentType("text/html");

		resp.getWriter().println("<form action='' method='POST'>");
		resp.getWriter().println("<label for='name'>Program Name:</label>");
		resp.getWriter().println("<input type='text' id='name' name='name' />");
		resp.getWriter().println("<br>");
		resp.getWriter().println("<label for='instructor'>instructor name:</label>");
		resp.getWriter().println("<input type='text' id='instructor' name='instructor' />");
		resp.getWriter().println("<br>");
		resp.getWriter().println("<label for='price'>price:</label>");
		resp.getWriter().println("<input type='text' id='price' name='price' />");
		resp.getWriter().println("<br>");
		resp.getWriter().println("<input type='submit' value='Create program' />");
		resp.getWriter().println("</form>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PersistenceManager pm = getPersistenceManager();

		try {
			pm.makePersistent(new Program(req.getParameter("name")));
			resp.sendRedirect("/display");
		} finally {
			pm.close();
		}
	}
	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
}
