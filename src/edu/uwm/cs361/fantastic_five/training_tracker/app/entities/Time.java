
package edu.uwm.cs361.fantastic_five.training_tracker.app.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Time {

	@Persistent
	public String day;
	
	@Persistent
	public String start_time;

	@Persistent
	public String end_time;
	
	public Time(String day, String start_time, String end_time){
		this.day = day;
		this.start_time = start_time;
		this.end_time = end_time;		
	}
	
	public String getDay(){
		return day;
	}
	
	public String get_times(){
		return start_time + " - " + end_time;
	}
	
	@Override
	public String toString(){
		return (day + ": "+ get_times());
	}
	
	
}
