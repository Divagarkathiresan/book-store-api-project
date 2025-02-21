package com.divagar.springapp.Entity;
import jakarta.persistence.*;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int PublisherID;
	public String Name;
	public String ContactNumber;
	public int getPublisherID() {
		return PublisherID;
	}
	public void setPublisherID(int publisherID) {
		PublisherID = publisherID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public Publisher(int publisherID, String name, String contactNumber) {
		PublisherID = publisherID;
		Name = name;
		ContactNumber = contactNumber;
	}
	public Publisher() {
	}
	
}
