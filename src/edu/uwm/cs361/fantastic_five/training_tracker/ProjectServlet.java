package edu.uwm.cs361.fantastic_five.training_tracker;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
