package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.StudentCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateStudentRequest;

@SuppressWarnings("serial")
public class CreateStudentFormServlet extends BaseServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		forwardToJsp("create_student_form.jsp", req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		CreateStudentRequest createRequest = new CreateStudentRequest();
		createRequest.firstName = req.getParameter("firstName");
		createRequest.lastName = req.getParameter("lastName");
		createRequest.email = req.getParameter("email");

		new StudentCreator().createStudent(createRequest);

		resp.sendRedirect("/students");
	}
}
