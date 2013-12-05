package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Session;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.AttendanceRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.AttendanceResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class AttendanceTaker {
	public AttendanceResponse takeAttendance(AttendanceRequest req) {
		AttendanceResponse resp = new AttendanceResponse();

		PersistenceManager pm = getPersistenceManager();
		
		try {
			if (req.date == null) {
				resp.success = false;
				resp.error = "No date selected";
				return resp;
			} else {
				Session session = new Session(req.date);
				try {
					pm.makePersistent(session);
				} finally {
					pm.close();
				}
				
				pm = getPersistenceManager();
				long studentId;
				long programId;
				try {
					if (req.ids != null) {
						for (String id : req.ids){
							studentId = Long.parseLong(id);
							Student student;
							try {
								student = pm.getObjectById(Student.class,studentId);
							} catch (JDOObjectNotFoundException e) {
								resp.success = false;
								resp.error = "The specified student does not exist";
								return resp;
							}
							session.addStudent(student);
						}
					}
				}
				catch (NumberFormatException ex) {
					resp.success = false;
					resp.error = "Invalid student id.";
	
					return resp;
				}
				try {
					programId = Long.parseLong(req.programId);
				} catch (NumberFormatException ex) {
					resp.success = false;
					resp.error = "Invalid program id.";
	
					return resp;
				}
	
				Program program;
	
				try {
					program = pm.getObjectById(Program.class, programId);
				} catch (JDOObjectNotFoundException ex) {
					resp.success = false;
					resp.error = "The specified program does not exist.";
	
					return resp;
				}
		
				program.addSession(session);
				resp.success = true;
			}
		}finally {
			pm.close();
		}

		return resp;
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
