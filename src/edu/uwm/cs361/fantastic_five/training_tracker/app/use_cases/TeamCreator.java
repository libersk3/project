
package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.services.PersistenceService;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateTeamRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateTeamResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.team;

public class TeamCreator {
	public CreateTeamResponse createTeam(CreateTeamRequest req) {
		PersistenceManager pm = getPersistenceManager();

		try {
			pm.makePersistent(new team(req.name, Double.parseDouble(req.price)));
			
		} finally {
			pm.close();
		}

		return new CreateTeamResponse();
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
