package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.entities.Program;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ProgramTest {
	
	@Test
	public void testName() {
		Program program = new Program("Example Program");
		
		assertEquals("Example Program", program.getName());
	}
	
	@Test
	public void testSetName() {
		Program program = new Program("Example Program");
		program.setName("Example Program 2");
		
		assertEquals("Example Program 2", program.getName());
	}

	@Test
	public void testInstructor() {
		Program program = new Program("Example Program");
		program.setInstructor("Andrew Meyer");
		
		assertEquals("Andrew Meyer", program.getInstructor());
	}
	
	@Test
	public void testPrice() {
		Program program = new Program("Example Program");
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
