package com.aroundu.AroundU.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private CustomerUser user;

    private String services;
    
    private String servicesLocation;
    
    private String qualification;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerUser getUser() {
		return user;
	}

	public void setUser(CustomerUser user) {
		this.user = user;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getServicesLocation() {
		return servicesLocation;
	}

	public void setServicesLocation(String servicesLocation) {
		this.servicesLocation = servicesLocation;
	}

	public ServiceProvider(Long id, CustomerUser user, String services, String servicesLocation, String qualification) {
		super();
		this.id = id;
		this.user = user;
		this.services = services;
		this.servicesLocation = servicesLocation;
		this.qualification = qualification;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

    
   
}
