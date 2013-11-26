package edu.uwm.cs361.fantastic_five.training_tracker.tests.use_cases;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.ProgramCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.ProgramViewer;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.StudentCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.StudentEnroller;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateProgramRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateStudentRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.EnrollStudentRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ViewProgramRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.EnrollStudentResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ViewProgramResponse;

import edu.uwm.cs361.fantastic_five.training_tracker.tests.AppEngineTest;

public class StudentEnrollerEnrollStudentTest extends AppEngineTest {
	private StudentEnroller studentEnroller;
	private EnrollStudentRequest req;
	private EnrollStudentResponse resp;

	@Before
	public void setUp() {
		studentEnroller = new StudentEnroller();
		req = new EnrollStudentRequest();

		createProgram("Example Program", "Andrew Meyer", "2.60");
		createStudent("Andrew", "Meyer", "andrew@example.com");
		createStudent("Charlie", "Liberski", "charlie@example.com");
	}

	private void generateValidRequest() {
		req.programId = Long.toString(getFirstProgram().getKey().getId());
		req.studentId = Long.toString(getFirstStudent().getKey().getId());
	}

	private void doRequest() {
		resp = studentEnroller.enrollStudent(req);
	}

	private void createProgram(String name, String instructor, String price) {
		CreateProgramRequest req = new CreateProgramRequest();
		req.name = name;
		req.instructor = instructor;
		req.price = price;

		new ProgramCreator().createProgram(req);
	}

	private void createStudent(String firstName, String lastName, String email) {
		CreateStudentRequest req = new CreateStudentRequest();
		req.firstName = firstName;
		req.lastName = lastName;
		req.email = email;

		new StudentCreator().createStudent(req);
	}

	@SuppressWarnings("unchecked")
	private List<Program> getAllPrograms() {
		PersistenceManager pm = getPersistenceManager();
		return (List<Program>) pm.newQuery(Program.class).execute();
	}
	private Program getFirstProgram() {
		List<Program> programs = getAllPrograms();
		return programs.iterator().next();
	}

	@SuppressWarnings("unchecked")
	private List<Student> getAllStudents() {
		PersistenceManager pm = getPersistenceManager();
		return (List<Student>) pm.newQuery(Student.class).execute();
	}
	private Student getFirstStudent() {
		List<Student> students = getAllStudents();
		return students.iterator().next();
	}

	@Test
	public void testEnrollSuccess() {
		generateValidRequest();
		doRequest();

		assertTrue(resp.success);
	}

	@Test
	public void testEnrollNoError() {
		generateValidRequest();
		doRequest();

		assertNull(resp.error);
	}

	@Test
	public void testStudentEnrolled() {
		Program program = getFirstProgram();
		Student student = getFirstStudent();

		req.programId = Long.toString(program.getKey().getId());
		req.studentId = Long.toString(student.getKey().getId());

		doRequest();

		ViewProgramRequest programReq = new ViewProgramRequest();
		programReq.id = Long.toString(program.getKey().getId());
		ViewProgramResponse programResp = new ProgramViewer().viewProgram(programReq);

		Student enrolledStudent = programResp.students.iterator().next();

		assertEquals(student.getKey().getId(), enrolledStudent.getKey().getId());
	}

	@Test
	public void testEnrollMultipleStudents() {
		Program program = getFirstProgram();
		List<Student> students = getAllStudents();

		for (Student student : students) {
			req.programId = Long.toString(program.getKey().getId());
			req.studentId = Long.toString(student.getKey().getId());
			doRequest();
		}

		ViewProgramRequest programReq = new ViewProgramRequest();
		programReq.id = Long.toString(program.getKey().getId());
		ViewProgramResponse programResp = new ProgramViewer().viewProgram(programReq);

		for (Student enrolledStudent : students) {
			assertThat(programResp.students, hasItem(enrolledStudent));
		}
	}

//	TODO: Make these tests pass
//	@Test
//	public void testEnrollBlankProgramIdFail() {
//		generateValidRequest();
//		req.programId = "";
//		doRequest();
//
//		assertFalse(resp.success);
//	}
//
//	@Test
//	public void testEnrollBlankProgramIdError() {
//		generateValidRequest();
//		req.programId = "";
//		doRequest();
//
//		assertNotNull(resp.error);
//		assertFalse(resp.error.isEmpty());
//	}
//
//	@Test
//	public void testEnrollInvalidProgramIdFail() {
//		generateValidRequest();
//		req.programId = "12345";
//		doRequest();
//
//		assertFalse(resp.success);
//	}
//
//	@Test
//	public void testEnrollInvalidProgramIdError() {
//		generateValidRequest();
//		req.programId = "12345";
//		doRequest();
//
//		assertNotNull(resp.error);
//		assertFalse(resp.error.isEmpty());
//	}
//
//	@Test
//	public void testEnrollBlankStudentIdFail() {
//		generateValidRequest();
//		req.studentId = "";
//		doRequest();
//
//		assertFalse(resp.success);
//	}
//
//	@Test
//	public void testEnrollBlankStudentIdError() {
//		generateValidRequest();
//		req.studentId = "";
//		doRequest();
//
//		assertNotNull(resp.error);
//		assertFalse(resp.error.isEmpty());
//	}
//
//	@Test
//	public void testEnrollInvalidStudentIdFail() {
//		generateValidRequest();
//		req.studentId = "12345";
//		doRequest();
//
//		assertFalse(resp.success);
//	}
//
//	@Test
//	public void testEnrollInvalidStudentIdError() {
//		generateValidRequest();
//		req.studentId = "12345";
//		doRequest();
//
//		assertNotNull(resp.error);
//		assertFalse(resp.error.isEmpty());
//	}
}
