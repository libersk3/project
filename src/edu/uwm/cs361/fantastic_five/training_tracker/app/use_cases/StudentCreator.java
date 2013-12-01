package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateStudentRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateStudentResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;
import edu.uwm.cs361.fantastic_five.training_tracker.services.StudentValidator;

public class StudentCreator {
	public CreateStudentResponse createStudent(CreateStudentRequest req) {
		PersistenceManager pm = getPersistenceManager();
		CreateStudentResponse resp = new CreateStudentResponse();

		resp.errors = new StudentValidator().validate(req.firstName, req.lastName, req.email);
		if (!resp.errors.isEmpty()) {
			resp.success = false;
			return resp;
		}

		try {
			pm.makePersistent(new Student(req.firstName, req.lastName, req.email, req.password));
			resp.success = true;
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
