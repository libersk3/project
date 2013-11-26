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

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Student)) return false;
		if (other == this) return true;

		Student otherS = (Student) other;
		if (!bothNullOrEqual(this.getKey(), otherS.getKey())) return false;
		if (!bothNullOrEqual(this.firstName, otherS.firstName)) return false;
		if (!bothNullOrEqual(this.lastName, otherS.lastName)) return false;
		if (!bothNullOrEqual(this._email, otherS._email)) return false;

		return true;
	}
	private boolean bothNullOrEqual(Object object1, Object object2) {
		return (object1 == null ? object2 == null : object1.equals(object2));
	}

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