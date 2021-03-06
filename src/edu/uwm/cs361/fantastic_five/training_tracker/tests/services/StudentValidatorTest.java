package edu.uwm.cs361.fantastic_five.training_tracker.tests.services;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.cs361.fantastic_five.training_tracker.services.StudentValidator;

public class StudentValidatorTest {
	private StudentValidator studentValidator;
	private Map<String, List<String>> errors;

	private String firstName;
	private String lastName;
	private String email;

	@Before
	public void setUp() {
		studentValidator = new StudentValidator();
	}

	private void validate() {
		errors = studentValidator.validate(firstName, lastName, email);
	}

	private void generateValidParams() {
		firstName = "Andrew";
		lastName = "Meyer";
		email = "test@example.com";
	}

	@Test
	public void testValidStudent() {
		generateValidParams();
		validate();

		assertTrue(errors.isEmpty());
	}

	@Test
	public void testBlankFirstName() {
		generateValidParams();
		firstName = "";

		validate();

		assertFalse(errors.isEmpty());
		assertNotNull(errors.get("firstName"));
		assertFalse(errors.get("firstName").isEmpty());
	}

	@Test
	public void testBlankLastName() {
		generateValidParams();
		lastName = "";

		validate();

		assertFalse(errors.isEmpty());
		assertNotNull(errors.get("lastName"));
		assertFalse(errors.get("lastName").isEmpty());
	}

	@Test
	public void testBlankEmail() {
		generateValidParams();
		email = "";

		validate();

		assertFalse(errors.isEmpty());
		assertNotNull(errors.get("email"));
		assertFalse(errors.get("email").isEmpty());
	}

	@Test
	public void testInvalidEmail() {
		generateValidParams();
		email = "asdf";

		validate();

		assertFalse(errors.isEmpty());
		assertNotNull(errors.get("email"));
		assertFalse(errors.get("email").isEmpty());
	}
}
