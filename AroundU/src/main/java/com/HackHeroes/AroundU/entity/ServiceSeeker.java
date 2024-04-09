package com.HackHeroes.AroundU.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="serviceseeker")
public class ServiceSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seeker_id")
	
	private Integer serviceseeker_id;
	private String name;
	private String phne_no;
	private String address;
	private String state;
	private String country;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceSeeker", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	
	private List<Booking> bookings;
	public ServiceSeeker() {
		super();
	}
	
	public ServiceSeeker(Integer serviceseeker_id, String name, String phne_no, String address, String state,
			String country, List<Booking> bookings) {
		super();
		this.serviceseeker_id = serviceseeker_id;
		this.name = name;
		this.phne_no = phne_no;
		this.address = address;
		this.state = state;
		this.country = country;
		this.bookings = bookings;
	}

	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public void setServiceseeker_id(Integer serviceseeker_id) {
		this.serviceseeker_id = serviceseeker_id;
	}

	public int getServiceseeker_id() {
		return serviceseeker_id;
	}
	public ServiceSeeker(int serviceseeker_id, String name, String phne_no, String address, String state,
			String country) {
		super();
		this.serviceseeker_id = serviceseeker_id;
		this.name = name;
		this.phne_no = phne_no;
		this.address = address;
		this.state = state;
		this.country = country;
	}
	public void setServiceseeker_id(int serviceseeker_id) {
		this.serviceseeker_id = serviceseeker_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhne_no() {
		return phne_no;
	}
	public void setPhne_no(String phne_no) {
		this.phne_no = phne_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
