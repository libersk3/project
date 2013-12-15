package edu.uwm.cs361.fantastic_five.training_tracker.app.entities;
import java.util.List;
import java.util.Set;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.datanucleus.annotations.Unowned;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Award {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	private String name;

	@Persistent
	private double price;
	
	@Persistent
	private double revenue;
	

	
	
	public Award(String name, double price)
	{
		this.name = name;
		this.price = price;		
	}

	public Key getKey()
	{
		return key;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	

	public double getPrice(){
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	


	public double getRevenue(){
		return revenue;
	}

	public double updateRevenue(double charge){
		return revenue += charge;
	}
	
}



