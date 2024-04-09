package com.HackHeroes.AroundU.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HackHeroes.AroundU.entity.ServiceProvider;
import com.HackHeroes.AroundU.repository.ServiceProviderRepository;

@Service
public class UpdateProfileProviderservice {
	
	@Autowired
	private ServiceProviderRepository serviceproviderrepository;
	
	
	
	
	 public void updateServiceProviderProfile(int id, ServiceProvider updatedServiceProvider) {
		    
	        Optional<ServiceProvider> serviceproviderOptional = serviceproviderrepository.findById(id);
	        if (serviceproviderOptional.isPresent()) {
	            ServiceProvider existingServiceProvider = serviceproviderOptional.get();
	            existingServiceProvider.setName(updatedServiceProvider.getName());
	            existingServiceProvider.setService(updatedServiceProvider.getService());
	            existingServiceProvider.setQualification(updatedServiceProvider.getQualification());
	             serviceproviderrepository.save(existingServiceProvider);   
	        } else {
	            throw new RuntimeException("Service seeker not found");
	        }
	    }

}

