package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	Student student;
	
	@Before
	public void setUpTest() {
		this.student = new Student("George", "Washington");
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals("George", student.getFirstName() );
	}
	
	@Test
	public void testGetLastName() {
		assertEquals("Washington", student.getLastName() );
	}
	
	@Test
	public void testSetFirstName() {
		student.setFirstName("Benjamin");
		assertEquals("Benjamin", student.getFirstName() );
	}
	
	@Test
	public void testSetLastName() {
		student.setLastName("Franklin");
		assertEquals("Franklin", student.getLastName() );
	}
	
} // end class
