package edu.uwm.cs361.fantastic_five.training_tracker.app.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Student {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	private String firstName;

	@Persistent
	private String lastName;

	@Persistent
	private String _email;

	@Persistent
	private double balance;



	//****************************************************

	public Student(String firstName, String lastName, String _email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this._email = _email;
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

	public String get_email(){
		return this._email;
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

	public double getBalance(){
		return balance;
	}

	public String balanceToString(){
		return String.format("$%.2f", new Double(balance));
	}

	public void updateBalance(double price){
		balance+=price;
	}

} //end class