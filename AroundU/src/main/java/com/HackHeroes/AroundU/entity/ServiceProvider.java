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
@Table(name="serviceprovider")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="serviceProviderid")
	private Integer serviceprovider_id;
	private String name;
	private String service;
	private String qualification;
	private String phone_no;
	@JsonIgnore
	@OneToMany(mappedBy = "serviceProvider", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	private List<Booking> bookings;
	
	public ServiceProvider() {
		super();
	}
	
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public ServiceProvider(Integer serviceprovider_id, String name, String service, String qualification, String reviews,
			String availibility, List<Booking> bookings,String Phone_no) {
		super();
		this.serviceprovider_id = serviceprovider_id;
		this.name = name;
		this.service = service;
		this.phone_no=Phone_no;
		this.qualification = qualification;
		this.bookings = bookings;
	}
	public ServiceProvider(int serviceprovider_id, String name, String service, String qualification,String Phone_no) {
		super();
		this.serviceprovider_id = serviceprovider_id;
		this.name = name;
		this.service = service;
		this.qualification = qualification;
		this.phone_no=Phone_no;
	}
	public int getServiceprovider_id() {
		return serviceprovider_id; 
	}
	public void setServiceprovider_id(int serviceprovider_id) {
		this.serviceprovider_id = serviceprovider_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	

}
