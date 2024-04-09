package com.HackHeroes.AroundU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HackHeroes.AroundU.entity.ServiceProvider;
import com.HackHeroes.AroundU.repository.ServiceProviderRepository;

@Service
public class AddProviderservice {
	
	
	private ServiceProviderRepository serviceProviderRepository;
    
    @Autowired
    public AddProviderservice(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }
    
    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

}

