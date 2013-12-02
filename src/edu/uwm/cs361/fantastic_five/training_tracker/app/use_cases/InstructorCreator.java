package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Instructor;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateInstructorRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateInstructorResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class InstructorCreator {
	public CreateInstructorResponse createInstructor(CreateInstructorRequest req) {
		PersistenceManager pm = getPersistenceManager();

		try {
			pm.makePersistent(new Instructor(req.firstName, req.lastName, req.username, req.password));
		} finally {
			pm.close();
		}

		return new CreateInstructorResponse();
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
