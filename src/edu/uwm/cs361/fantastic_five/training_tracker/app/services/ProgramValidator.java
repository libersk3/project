package edu.uwm.cs361.fantastic_five.training_tracker.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Instructor;

public class ProgramValidator {
	private Map<String, List<String>> errors;

	public Map<String, List<String>> validate(String name, Instructor instructor, String price) {
		errors = new HashMap<String, List<String>>();

		validateName(name);
		validateInstructor(instructor);
		validatePrice(price);

		return errors;
	}

	private void validateName(String name) {
		List<String> nameErrors = new ArrayList<String>();

		if (name == null || name.isEmpty()) {
			nameErrors.add("Name must not be blank.");
		}

		if (!nameErrors.isEmpty()) errors.put("name", nameErrors);
	}

	private void validateInstructor(Instructor instructor) {
		List<String> instructorErrors = new ArrayList<String>();

		if (instructor == null)
			instructorErrors.add("Invalid instructor");

		if (!instructorErrors.isEmpty()) errors.put("instructor", instructorErrors);
	}

	private void validatePrice(String price) {
		List<String> numberErrors = validateDouble(price, "Price");
		if (!numberErrors.isEmpty()) errors.put("price", numberErrors);
	}

	private List<String> validateDouble(String numberString, String name) {
		ArrayList<String> numberErrors = new ArrayList<String>();

		if (numberString == null || numberString.isEmpty()) {
			numberErrors.add(name + " must not be blank.");
		} else {
			try {
				Double.parseDouble(numberString);
			} catch (NumberFormatException ex) {
				numberErrors.add(name + " is invalid.");
			}
		}

		return numberErrors;
	}
}
