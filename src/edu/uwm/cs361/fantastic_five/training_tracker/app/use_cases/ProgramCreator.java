package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateProgramRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateProgramResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class ProgramCreator {
	public CreateProgramResponse createProgram(CreateProgramRequest req) {
		PersistenceManager pm = getPersistenceManager();
		CreateProgramResponse resp = new CreateProgramResponse();

		if (req.name == null || req.name.isEmpty()) {
			resp.errors.put("name", new ArrayList<String>());
			resp.errors.get("name").add("Name must not be blank.");
		}

		if (req.instructor == null || req.instructor.isEmpty()) {
			resp.errors.put("instructor", new ArrayList<String>());
			resp.errors.get("instructor").add("Instructor must not be blank.");
		}

		ArrayList<String> priceErrors = new ArrayList<String>();
		double price = 0;
		if (req.price == null || req.price.isEmpty()) {
			priceErrors.add("Price must not be blank.");
		} else {
			try {
				price = Double.parseDouble(req.price);
			} catch (NumberFormatException ex) {
				priceErrors.add("Price is invalid.");
			}
		}
		if (!priceErrors.isEmpty()) resp.errors.put("price", priceErrors);

		if (!resp.errors.isEmpty()) {
			resp.success = false;
			return resp;
		} else {
			resp.success = true;
		}

		try {
			pm.makePersistent(new Program(req.name, req.instructor, price));
		} finally {
			pm.close();
		}

		return resp;
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
