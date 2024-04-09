package com.HackHeroes.AroundU.entity.dao;

public class ServiceProviderDTO {
	

    private String name;
    private String service;
  
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

	public ServiceProviderDTO(String name, String service) {
		super();
		this.name = name;
		this.service = service;
		
	}
	public ServiceProviderDTO() {
		super();
	}
	

}


