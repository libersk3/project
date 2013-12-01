package edu.uwm.cs361.fantastic_five.training_tracker.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidator {
	private Map<String, List<String>> errors;

	// Not a very robust solution, but it should work fine for now.
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Map<String, List<String>> validate(String firstName, String lastName, String email) {
		errors = new HashMap<String, List<String>>();

		validateFirstName(firstName);
		validateLastName(lastName);
		validateEmail(email);

		return errors;
	}

	private void validateFirstName(String firstName) {
		List<String> nameErrors = new ArrayList<String>();

		if (firstName == null || firstName.isEmpty()) {
			nameErrors.add("First name must not be blank.");
		}

		if (!nameErrors.isEmpty()) errors.put("firstName", nameErrors);
	}

	private void validateLastName(String lastName) {
		List<String> nameErrors = new ArrayList<String>();

		if (lastName == null || lastName.isEmpty()) {
			nameErrors.add("Last name must not be blank.");
		}

		if (!nameErrors.isEmpty()) errors.put("lastName", nameErrors);
	}

	private void validateEmail(String email) {
		List<String> emailErrors = new ArrayList<String>();

		if (email == null || email.isEmpty()) {
			emailErrors.add("Email must not be blank.");
		}
		if (!emailIsValid(email)) {
			emailErrors.add("Email must be valid.");
		}

		if (!emailErrors.isEmpty()) errors.put("email", emailErrors);
	}

	private boolean emailIsValid(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
