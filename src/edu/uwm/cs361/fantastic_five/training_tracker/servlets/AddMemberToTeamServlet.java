	package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

	import java.io.IOException;

	import javax.servlet.ServletException;
import javax.servlet.http.*;

	import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.StudentEnroller;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.teamMemberEnroller;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.EnrollStudentRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ListUnenrolledStudentsRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.addTeamMemberRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.EnrollStudentResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ListUnenrolledStudentsResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.addTeamMember;

	@SuppressWarnings("serial")
	public class AddMemberToTeamServlet extends BaseServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			ListUnenrolledStudentsRequest listUnenrolledStudentsReq = new ListUnenrolledStudentsRequest();
			listUnenrolledStudentsReq.programId = req.getParameter("id");

			ListUnenrolledStudentsResponse listUnenrolledStudentsResponse = new StudentEnroller().listUnenrolledStudents(listUnenrolledStudentsReq);

			req.setAttribute("team", listUnenrolledStudentsResponse.program);
			req.setAttribute("StudentsList", listUnenrolledStudentsResponse.unenrolledStudents);
			forwardToJsp("addTeamMember.jsp", req, resp);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
		{
			addTeamMemberRequest addTeamMemberRequest = new addTeamMemberRequest();
			addTeamMemberRequest.studentId = req.getParameter("student");
			addTeamMemberRequest.teamId = req.getParameter("id");

			addTeamMember addTeamMemberResponse = new teamMemberEnroller().addTeamMember(addTeamMemberRequest);

			if (addTeamMember.success) {
				resp.sendRedirect("/programs");
			} else {
				resp.setContentType("text/html");

				resp.getWriter().println("<h3>Error: " + addTeamMember.error + "</h3>");
				resp.getWriter().println("<form action='/programs'>");
				resp.getWriter().println("<input type='submit' value='Back to Programs Page'>");
				resp.getWriter().println("</form>");
			}
		}
	}

	
	
}
