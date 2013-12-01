package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Instructor;

public class InstructorTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalTaskQueueTestConfig(), new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}
	
	Instructor instructor;
	
	@Before
	public void setUpTest() {
		this.instructor = new Instructor("Abraham", "Lincoln", "coln267", "mypass");
	}

	@Test
	public void testGetKey() {
		Instructor instructor2 = new Instructor("Abraham", "Lincoln", "coln267", "mypass");

		PersistenceManager pm = getPersistenceManager();

		pm.makePersistent(instructor);
		pm.makePersistent(instructor2);

		assertThat(instructor.getKey(), is(not(instructor2.getKey())));			//prove each instructor has unique key
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals("Abraham", instructor.getFirstName() );
	}

	@Test
	public void testGetLastName() {
		assertEquals("Lincoln", instructor.getLastName() );
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("coln267", instructor.getUsername());
	}

	@Test
	public void testGetPassword() {
		assertEquals("mypass", instructor.getPassword());
	}
	
	@Test
	public void testSetFirstName() {
		instructor.setFirstName("Benjamin");
		assertEquals("Benjamin", instructor.getFirstName() );
	}

	@Test
	public void testSetLastName() {
		instructor.setLastName("Franklin");
		assertEquals("Franklin", instructor.getLastName() );
	}
	
	@Test
	public void testSetUsername() {
		instructor.setUsername("abester");
		assertEquals("abester", instructor.getUsername());
	}
	
	@Test
	public void testSetPassword() {
		instructor.setPassword("happy");
		assertEquals("happy", instructor.getPassword());
	}
	
	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
	
} //end class
