package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class SignUpServlet extends BaseServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		resp.getWriter().println("<form action= '' method='POST'>");
		resp.getWriter().println("<input type='password' name='password'/>");
		resp.getWriter().println("<br><input type='submit' value='Submit'/>");
		resp.getWriter().println("</form>");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String password = req.getParameter("password");
		if (password.equals("password")) {
			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			Entity user = new Entity("User");
			user.setProperty("username", "admin");
			user.setProperty("password", "password");
			user.setProperty("access", "Admin");
			ds.put(user);
			resp.sendRedirect("/login");
		}
	}
}
