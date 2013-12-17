package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.TeamViewer;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ViewTeamRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ViewTeamResponse;

@SuppressWarnings("serial")
public class SingleTeamServlet extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		TeamViewer TeamViewer = new TeamViewer();

		ViewTeamRequest viewTeamReq = new ViewTeamRequest();
		viewTeamReq.id = req.getParameter("id");

		ViewTeamResponse viewTeamResp = TeamViewer.viewTeam(viewTeamReq);

		if (viewTeamResp.team != null) {
			req.setAttribute("team", viewTeamResp.team);
			req.setAttribute("students", viewTeamResp.students);

			forwardToJsp("team.jsp", req, resp);
		} else {
			forwardToJsp("team_404.jsp", req, resp);
		}
	}
}
