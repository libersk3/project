package edu.uwm.cs361.fantastic_five.training_tracker;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String nextJSP = "/WEB-INF/pages/login.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("User").setFilter(
				Query.CompositeFilterOperator.and(
					new Query.FilterPredicate("username",Query.FilterOperator.EQUAL,req.getParameter("username")),
					new Query.FilterPredicate("password",Query.FilterOperator.EQUAL,req.getParameter("password"))
					)
				);
		if (ds.prepare(q).countEntities(FetchOptions.Builder.withDefaults()) > 0) {
			Cookie c = new Cookie("username",req.getParameter("username"));
			resp.addCookie(c);
			resp.sendRedirect("/user");
		} else {
			req.setAttribute("error", true);

			String nextJSP = "/WEB-INF/pages/login.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(req, resp);
		}
	}
}
