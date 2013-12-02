package edu.uwm.cs361.fantastic_five.training_tracker.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;

public class StudentTest {

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
	
	Student student;

	@Before
	public void setUpTest() {
		this.student = new Student("George", "Washington", "gw@gmail.com", "mypass");
	}

	@Test
	public void testGetKey() {
		Student student2 = new Student("George", "Washington", "gw@gmail.com", "mypass");

		PersistenceManager pm = getPersistenceManager();

		pm.makePersistent(student);
		pm.makePersistent(student2);

		assertThat(student.getKey(), is(not(student2.getKey())));			//prove each student has unique key
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
	public void testGetEmail() {
		assertEquals("gw@gmail.com", student.get_email());
	}

	@Test
	public void testGetPassword() {
		assertEquals("mypass", student.getPassword());
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
	public void testSetEmail() {
		student.setEmail("al@gmail.com");
		assertEquals("al@gmail.com", student.get_email());
	}
	
	@Test
	public void testSetPassword() {
		student.setPassword("happy");
		assertEquals("happy", student.getPassword());
	}

	@Test
	public void testUpdateBalance() {
		student.updateBalance(5.00);
		assertEquals(5.00, student.getBalance(), .001);
	}

	@Test
	public void testBalanceToString(){
		student.updateBalance(5.00);
		assertEquals("$5.00", student.balanceToString());
	}
	
	private PersistenceManager getPersistenceManager()
	{
		return JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}

} // end class
