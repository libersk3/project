package edu.uwm.cs361.fantastic_five.training_tracker.tests.use_cases;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.StudentCreator;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.StudentFinder;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateStudentRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ListStudentsRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ListStudentsResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.tests.AppEngineTest;

public class StudentFinderListStudentsTest extends AppEngineTest {
	StudentFinder studentFinder;
	ListStudentsRequest req;
	ListStudentsResponse resp;

	@Before
	public void setUp() {
		studentFinder = new StudentFinder();
		req = new ListStudentsRequest();
	}

	private void doRequest() {
		resp = studentFinder.listStudents(req);
	}

	private void createStudent(String firstName, String lastName, String email) {
		CreateStudentRequest req = new CreateStudentRequest();
		req.firstName = firstName;
		req.lastName = lastName;
		req.email = email;

		new StudentCreator().createStudent(req);
	}

	private void createStudents() {
		createStudent("Andrew", "Meyer", "andrew@example.com");
		createStudent("Charlie", "Liberski", "charlie@example.com");
	}

	@Test
	public void testListStudentsNotEmpty() {
		createStudents();
		doRequest();

		assertFalse(resp.students.isEmpty());
	}

	@Test
	public void testListStudentsCount() {
		createStudents();
		doRequest();

		Iterator<Student> iterator = resp.students.iterator();
		for (int i = 0; i < 2; ++i) {
			assertTrue(iterator.next() != null);
		}
	}

	@Test
	public void testListEntriesCorrect() {
		createStudents();
		doRequest();

		Iterator<Student> iterator = resp.students.iterator();
		for (int i = 0; i < 2; ++i) {
			Student student = iterator.next();

			assertTrue(student.getFirstName().equals("Andrew") || student.getFirstName().equals("Charlie"));

			if (student.getFirstName().equals("Andrew")) {
				assertEquals("Meyer", student.getLastName());
				assertEquals("andrew@example.com", student.get_email());
			} else { // student.getFirstName().equals("Charlie")
				assertEquals("Liberski", student.getLastName());
				assertEquals("charlie@example.com", student.get_email());
			}
		}
	}

	@Test
	public void testListStudentsWithNoStudents() {
		doRequest();

		assertTrue(resp.students.isEmpty());
	}

}
