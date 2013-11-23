package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import java.util.List;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ListProgramsRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ListProgramsResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class ProgramFinder {
	@SuppressWarnings("unchecked")
	public ListProgramsResponse listPrograms(ListProgramsRequest req) {
		ListProgramsResponse resp = new ListProgramsResponse();

		PersistenceManager pm = getPersistenceManager();

		resp.programs = (List<Program>) pm.newQuery(Program.class).execute();

		return resp;
	}

	public ListProgramsResponse listPrograms() {
		return listPrograms(new ListProgramsRequest());
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
