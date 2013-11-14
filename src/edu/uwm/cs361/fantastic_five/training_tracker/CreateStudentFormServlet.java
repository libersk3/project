package edu.uwm.cs361.fantastic_five.training_tracker;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;

@SuppressWarnings("serial")
public class CreateStudentFormServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String nextJSP = "/WEB-INF/pages/create_student_form.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);
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
		private PersistenceManager getPersistenceManager()
		{
			return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		}

} //end class
