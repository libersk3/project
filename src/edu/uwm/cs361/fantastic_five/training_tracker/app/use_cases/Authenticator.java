package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.LogInRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.LogInResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public abstract class Authenticator {


	public abstract LogInResponse authenticate(LogInRequest req);

	protected PersistenceManager getPersistenceManager() {
		return PersistenceService.getPersistenceManager();
	}

} //end interface