package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.StudentCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateStudentRequest;

@SuppressWarnings("serial")
public class CreateInstructorFormServlet extends BaseServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		forwardToJsp("create_instructor_form.jsp", req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		CreateStudentRequest createRequest = new CreateStudentRequest();
		createRequest.firstName = req.getParameter("firstName");
		createRequest.lastName = req.getParameter("lastName");
		createRequest.username = req.getParameter("username");
		createRequest.password = req.getParameter("password");

		new StudentCreator().createStudent(createRequest);

		resp.sendRedirect("/instructors");
	}
}
