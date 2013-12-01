package edu.uwm.cs361.fantastic_five.training_tracker.app.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Instructor {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	private String firstName;

	@Persistent
	private String lastName;

	@Persistent
	private String _username;
	
	@Persistent
	private String _password;

	@Persistent
	private double balance;



	//****************************************************

	public Instructor(String firstName, String lastName, String _username, String _pass) {

		this.firstName = firstName;
		this.lastName = lastName;
		this._username = _username;
		this._password = _pass;
		balance = 0.0;
	}

	//****************************************************

	public Key getKey() {
		return this.key;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getUsername(){
		return this._username;
	}
	
	public String getPassword() {
		return this._password;
	}

	public String getFullName() {
		return(this.firstName +" " + this.lastName);
	}

	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	
	public void setUsername(String u) {
		this._username = u;
	}

	public void setPassword(String p) {
		this._password = p;
	}
	
} //end class
