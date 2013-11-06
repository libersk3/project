package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class ProgramTest {
	Program program;
	
	@Before
	public void setUpTests() {
		this.program = new Program("Example Program");
	}
	
	@Test
	public void testName() {
		assertEquals("Example Program", program.getName());
	}
	
	@Test
	public void testSetName() {
		program.setName("Example Program 2");
		
		assertEquals("Example Program 2", program.getName());
	}

	@Test
	public void testInstructor() {
		program.setInstructor("Andrew Meyer");
		
		assertEquals("Andrew Meyer", program.getInstructor());
	}
	
	@Test
	public void testPrice() {
		program.setPrice(22.50);
		
		assertTrue(22.50 == program.getPrice());
	}
	
//	@Test
//	public void testKey() {
//		Program program = new Program("Example Program");
//		Program program2 = new Program("Example Program");
//		
//		PersistenceManager pm = getPersistenceManager();
//		
//		pm.makePersistent(program);
//		pm.makePersistent(program2);
//		
//		assertThat(program.getKey(), is(not(program2.getKey())));
//	}
//
//	private PersistenceManager getPersistenceManager()
//	{
//		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
//	}
	
}
