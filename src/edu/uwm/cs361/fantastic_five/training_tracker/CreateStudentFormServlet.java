package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class CreateStudentFormServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
			
			resp.setContentType("text/html");
	
			resp.getWriter().println("<form action='/students/new' method='POST'>");
			resp.getWriter().println("<label for=''>Enter New Student Information Below: </label>");
			resp.getWriter().println("<br>");
			resp.getWriter().println("<label for='firstName'>First Name: </label>");
			resp.getWriter().println("<input type='text' id='firstName' name='firstName' />");
			resp.getWriter().println("<br>");
			resp.getWriter().println("<label for='lastName'>Last Name: </label>");
			resp.getWriter().println("<input type='text' id='lastName' name='lastName' />");
			resp.getWriter().println("<br>");
			resp.getWriter().println("<input type='submit' value='Create Student' />");
			resp.getWriter().println("</form>");
		}
		
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
		{
			PersistenceManager pm = getPersistenceManager();
	
			try {
				
				pm.makePersistent(new Student(
					req.getParameter("firstName"),
					req.getParameter("lastName")
				));
				resp.sendRedirect("/students");
			} finally {
				pm.close();
			}
		}
		private PersistenceManager getPersistenceManager()
		{
			return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		}
	
} //end class
