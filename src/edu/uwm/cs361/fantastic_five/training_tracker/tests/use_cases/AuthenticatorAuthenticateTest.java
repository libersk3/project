package edu.uwm.cs361.fantastic_five.training_tracker.tests.use_cases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.Authenticator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.LogInRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.LogInResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.tests.AppEngineTest;

public class AuthenticatorAuthenticateTest extends AppEngineTest {
	private Authenticator authenticator;
	private LogInRequest req;
	private LogInResponse resp;

	@Before
	public void setUp() {
		authenticator = new Authenticator();
		req = new LogInRequest();
	}

	private void doRequest() {
		resp = authenticator.authenticate(req);
	}

	private void createUser() {
		// Not sure whether relying on other test cases is a good idea or not,
		// but I'll give it a try. (Maybe later we should switch to TestNG?)
		UserCreatorSignUpTest signUp = new UserCreatorSignUpTest();
		signUp.setUp();
		signUp.testSignUpValidPasswordResponse();
	}

	@Test
	public void testSuccessfulAuthentication() {
		createUser();

		req.username = "admin";
		req.password = "password";
		doRequest();

		assertTrue(resp.success);
	}

	@Test
	public void testAuthenticateNonexistantUser() {
		req.username = "admin";
		req.password = "password";
		doRequest();

		assertFalse(resp.success);
	}

	@Test
	public void testAuthenticateIncorrectPassword() {
		createUser();

		req.username = "admin";
		req.password = "asdf";
		doRequest();

		assertFalse(resp.success);
	}

	@Test
	public void testAuthenticateBlankPassword() {
		createUser();

		req.username = "admin";
		req.password = "";
		doRequest();

		assertFalse(resp.success);
	}

	@Test
	public void testAuthenticateBlankUsername() {
		createUser();

		req.username = "";
		req.password = "password";
		doRequest();

		assertFalse(resp.success);
	}
}
