package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.ProgramCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateProgramRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateProgramResponse;

@SuppressWarnings("serial")
public class NewProgramFormServlet extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		forwardToJsp("new_program_form.jsp", req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		CreateProgramRequest createRequest = new CreateProgramRequest();
		createRequest.name = req.getParameter("name");
		createRequest.instructor = req.getParameter("instructor");
		createRequest.price = req.getParameter("price");

		CreateProgramResponse createResponse = new ProgramCreator().createProgram(createRequest);

		if (createResponse.success) {
			resp.sendRedirect("/programs");
		} else {
			req.setAttribute("name", req.getParameter("name"));
			req.setAttribute("instructor", req.getParameter("instructor"));
			req.setAttribute("price", req.getParameter("price"));

			req.setAttribute("errors", createResponse.errors);

			forwardToJsp("new_program_form.jsp", req, resp);
		}


	}
}
