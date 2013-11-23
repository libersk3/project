package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.junit.Assert.*;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Program;

import org.junit.Before;
import org.junit.Test;

public class ProgramTest {
	Program program;

	@Before
	public void setUpTests() {
		this.program = new Program("Example Program", "Andrew Meyer", 22.50);
	}

	@Test
	public void testGetName() {
		assertEquals("Example Program", program.getName());
	}
	@Test
	public void testSetName() {
		program.setName("Example Program 2");

		assertEquals("Example Program 2", program.getName());
	}

	@Test
	public void testGetInstructor() {
		assertEquals("Andrew Meyer", program.getInstructor());
	}
	@Test
	public void testSetInstructor() {
		program.setInstructor("Charlie Liberski");

		assertEquals("Charlie Liberski", program.getInstructor());
	}

	@Test
	public void testGetPrice() {
		assertEquals(22.50, program.getPrice(), 0.001);
	}
	public void testSetPrice() {
		program.setPrice(20.00);

		assertEquals(20.00, program.getPrice(), 0.001);
	}
}
