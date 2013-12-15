package edu.uwm.cs361.fantastic_five.training_tracker.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountValidator {
	private Map<String, List<String>> errors;

	public Map<String, List<String>> validate(String address, String phone) {
		errors = new HashMap<String, List<String>>();

		validateAddress(address);
		validatePhone(phone);

		return errors;
	}

	private void validateAddress(String address) {
		List<String> addressErrors = new ArrayList<String>();

		if (address == null || address.isEmpty()) {
			addressErrors.add("Address must not be blank.");
		}

		if (!addressErrors.isEmpty()) errors.put("address", addressErrors);
	}

	private void validatePhone(String phone) {
		List<String> phoneErrors = new ArrayList<String>();

		if (phone == null || phone.isEmpty()) {
			phoneErrors.add("Phone must not be blank.");
		}
		
		boolean err = false;
		int i;
		for (i=0; i<12 && i<phone.length() && !err; ++i) {
			if (i == 3 || i == 7) {
				if (phone.charAt(i) != '-')
					err = true;
			}
			else if (!Character.isDigit(phone.charAt(i)))
				err = true;
		}
		if (i < 12)
			err = true;
		
		if (err)
			phoneErrors.add("Phone number format is incorrect - should be ###-###-####");
		if (!phoneErrors.isEmpty()) errors.put("phone", phoneErrors);
	}
}

