package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.ProgramCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateProgramRequest;

@SuppressWarnings("serial")
public class NewProgramFormServlet extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		forwardToJsp("new_program_form.jsp", req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		CreateProgramRequest createRequest = new CreateProgramRequest();
		createRequest.name = req.getParameter("name");
		createRequest.instructor = req.getParameter("instructor");
		createRequest.price = req.getParameter("price");

		new ProgramCreator().createProgram(createRequest);

		resp.sendRedirect("/programs");
	}
}
