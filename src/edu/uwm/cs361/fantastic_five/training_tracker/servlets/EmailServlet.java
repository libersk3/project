package edu.uwm.cs361.fantastic_five.training_tracker.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Account;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Time;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.AccountFinder;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.InstructorFinder;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.ProgramCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateProgramRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateProgramResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ListAccountsResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ListInstructorsResponse;

@SuppressWarnings("serial")
public class EmailServlet extends BaseServlet {


	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		ListAccountsResponse listAccountsResp = new AccountFinder().listAccounts();
		req.setAttribute("accounts", listAccountsResp.accounts);
		
		
		
		resp.setContentType("text/html");
		resp.getWriter().println("<form method='POST'>");
		resp.getWriter().println("<input type='text' name='email' />");
		resp.getWriter().println("<input type='submit' value='Send Email' />");
		resp.getWriter().println("</form>");
		forwardToJsp("email.jsp", req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "...";

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("libersk3@uwm.edu", "Charlie Liberski"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(req.getParameter("email"), req.getParameter("email")));
			msg.setSubject("Test Email");
			msg.setText(msgBody);
			Transport.send(msg);
		} catch (Exception e) {
			resp.getWriter().println("Problem sending email to " + req.getParameter("email") + ".");
			return;
		}

		resp.getWriter().println("Email sent.");
	}
}
