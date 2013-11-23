package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ViewProgramRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ViewProgramResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class ProgramViewer {
	public ViewProgramResponse viewProgram(ViewProgramRequest req) {
		ViewProgramResponse resp = new ViewProgramResponse();
		PersistenceManager pm = getPersistenceManager();

		String id = req.id;
		long idLong = Long.parseLong(id);
		Program program = pm.getObjectById(Program.class, idLong);

		resp.program = program;
		if (program != null) resp.students = program.listStudents();

		return resp;
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
