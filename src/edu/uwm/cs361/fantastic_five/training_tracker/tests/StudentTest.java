package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.junit.Assert.*;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Student;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	Student student;
	
	@Before
	public void setUpTest() {
		this.student = new Student("George", "Washington", "gw@gmail.com");
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
	
	@Test
	public void testUpdateBalance() {
		student.updateBalance(5.00);
		assertEquals(5.00, student.getBalance(), .001);
	}
	
	@Test
	public void testBalanceToString(){
		student.updateBalance(5.00);
		assertEquals("$5.00",student.BalanceToString());
	}
	
} // end class
