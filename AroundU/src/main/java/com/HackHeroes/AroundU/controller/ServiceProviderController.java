package com.HackHeroes.AroundU.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HackHeroes.AroundU.entity.ServiceProvider;
import com.HackHeroes.AroundU.service.AddProviderservice;

@RestController
public class ServiceProviderController {
	
private AddProviderservice Addproviderservice;
    
    @Autowired
    public ServiceProviderController( AddProviderservice serviceProviderService) {
        this.Addproviderservice = serviceProviderService;
    }
    
    @PostMapping("/api/service-providers")
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        ServiceProvider createdServiceProvider = Addproviderservice.createServiceProvider(serviceProvider);
        return new ResponseEntity<>(createdServiceProvider, HttpStatus.CREATED);
    }

}