package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.time;
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
		boolean chooseDays = req.getParameter(" ");
		String days = req.getParameter("day");
		String[] day_array = days.split(",");
		List<time> datesAndTimes = new ArrayList<time>();
		for(String s:day_array){
			//if(s.equals("sun")){
				datesAndTimes.add(new time("Sunday",req.getParameter("sun_start"), req.getParameter("mon_end")));
			if(s.equals("mon")){
				datesAndTimes.add(new time("Monday",req.getParameter("mon_start"), req.getParameter("mon_end")));
			}else if(s.equals("tue")){
				datesAndTimes.add(new time("Tuesday",req.getParameter("tue_start"), req.getParameter("tue_end")));
			}else if(s.equals("wed")){
				datesAndTimes.add(new time("Wednesday",req.getParameter("wed_start"), req.getParameter("wed_end")));
			}else if(s.equals("thu")){
				datesAndTimes.add(new time("Thursday",req.getParameter("thu_start"), req.getParameter("thu_end")));
			}else if(s.equals("fri")){
				datesAndTimes.add(new time("Friday",req.getParameter("fri_start"), req.getParameter("fri_end")));
			}else if(s.equals("sat")){
				datesAndTimes.add(new time("Saturday",req.getParameter("sat_start"), req.getParameter("sat_end")));
			}
		}
		createRequest.dates = datesAndTimes;
		new ProgramCreator().createProgram(createRequest);

		resp.sendRedirect("/programs");
	}
}
