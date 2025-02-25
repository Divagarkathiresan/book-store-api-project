package com.divagar.springapp.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisherid")
    private Long publisherId;

    @Column(name = "name" , unique = true)
    private String name;

    @Column(name = "contactnumber")
    private String contactNumber;

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Publisher() {
	}

	public Publisher(Long publisherId, String name, String contactNumber) {
		this.publisherId = publisherId;
		this.name = name;
		this.contactNumber = contactNumber;
	}

	
	
}
