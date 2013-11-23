package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateStudentRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateStudentResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class StudentCreator {
	public CreateStudentResponse createStudent(CreateStudentRequest req) {
		PersistenceManager pm = getPersistenceManager();

		try {
			pm.makePersistent(new Student(req.firstName, req.lastName, req.email));
		} finally {
			pm.close();
		}

		return new CreateStudentResponse();
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
