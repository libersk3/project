package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.EnrollStudentRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ListUnenrolledStudentsRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.EnrollStudentResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ListUnenrolledStudentsResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class StudentEnroller {
	@SuppressWarnings("unchecked")
	public ListUnenrolledStudentsResponse listUnenrolledStudents(ListUnenrolledStudentsRequest req) {
		ListUnenrolledStudentsResponse resp = new ListUnenrolledStudentsResponse();

		PersistenceManager pm = getPersistenceManager();
		try {
			Query q = pm.newQuery(Student.class);
			List<Student> allStudents = (List<Student>) q.execute();

			long programId = Long.parseLong(req.programId);
			Program program = pm.getObjectById(Program.class, programId);

			ArrayList<Student> unenrolledStudents = new ArrayList<Student>(allStudents);
			unenrolledStudents.removeAll(program.listStudents());

			resp.program = program;
			resp.unenrolledStudents = unenrolledStudents;
		} finally {
			pm.close();
		}

		return resp;
	}

	public EnrollStudentResponse enrollStudent(EnrollStudentRequest req) {
		EnrollStudentResponse resp = new EnrollStudentResponse();

		PersistenceManager pm = getPersistenceManager();

		try {
			if (req.studentId == null) {
				resp.success = false;
				resp.error = "No student selected";
			} else {
				long studentId = Long.parseLong(req.studentId);
				long programId = Long.parseLong(req.programId);

				Program program = pm.getObjectById(Program.class, programId);
				Student student = pm.getObjectById(Student.class, studentId);

				program.addStudent(student);

				resp.success = true;
			}
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
