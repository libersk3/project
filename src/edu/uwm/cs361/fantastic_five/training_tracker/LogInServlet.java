package edu.uwm.cs361.fantastic_five.training_tracker;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class LogInServlet extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		resp.getWriter().println("<h1> Log In </h1>");
		if (req.getParameter("error") != null)
			resp.getWriter().println("<h3>**Username or password is incorrect**</h3>");
		
		resp.getWriter().println("<form action= '/login' method='POST'>"); 
		resp.getWriter().println("<br><br>Username: <input type='text' name='username'/>");
		resp.getWriter().println("<br>Password: <input type='password' name='password'/>");
		resp.getWriter().println("<br><input type='submit' value='Log In'/>");
		resp.getWriter().println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("User").setFilter(
				Query.CompositeFilterOperator.and(
					new Query.FilterPredicate("username",Query.FilterOperator.EQUAL,req.getParameter("username")),
					new Query.FilterPredicate("password",Query.FilterOperator.EQUAL,req.getParameter("password"))
					)
				);
		if (ds.prepare(q).countEntities(FetchOptions.Builder.withDefaults()) > 0)
		{
			Cookie c = new Cookie("username",req.getParameter("username"));
			resp.addCookie(c);
			resp.sendRedirect("/user");
		}
		else
			resp.sendRedirect("/login?error=1");
	}
}
