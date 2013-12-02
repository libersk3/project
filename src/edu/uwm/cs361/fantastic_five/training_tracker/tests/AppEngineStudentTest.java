package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import javax.jdo.PersistenceManager;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;

public class AppEngineStudentTest extends AppEngineTest {
	Student student;

	@Before
	public void setUpTest() {
		this.student = new Student("George", "Washington", "gw@gmail.com", "test_password");
	}

	@Test
	public void testKey() {
		Student student2 = new Student("George", "Washington", "gw@gmail.com", "test_password");

		PersistenceManager pm = getPersistenceManager();

		pm.makePersistent(student);
		pm.makePersistent(student2);

		assertThat(student.getKey(), is(not(student2.getKey())));
	}
}
