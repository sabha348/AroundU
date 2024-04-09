package com.HackHeroes.AroundU.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HackHeroes.AroundU.entity.ServiceSeeker;
import com.HackHeroes.AroundU.repository.ServiceSeekerRepository;

@Service
public class UpdateProfileSeekerservice {
	
	

	@Autowired
	private ServiceSeekerRepository serviceseekerrepository;
	
	
	 
	
   
    public void updateServiceSeekerProfile(int id, ServiceSeeker updatedServiceSeeker) {
    
        Optional<ServiceSeeker> serviceseekerOptional = serviceseekerrepository.findById(id);
        if (serviceseekerOptional.isPresent()) {
            ServiceSeeker existingServiceSeeker = serviceseekerOptional.get();
            existingServiceSeeker.setName(updatedServiceSeeker.getName());
            existingServiceSeeker.setPhne_no(updatedServiceSeeker.getPhne_no());
            existingServiceSeeker.setAddress(updatedServiceSeeker.getAddress());
            existingServiceSeeker.setState(updatedServiceSeeker.getState());
            existingServiceSeeker.setCountry(updatedServiceSeeker.getCountry());
            serviceseekerrepository.save(existingServiceSeeker);
        } else {
            throw new RuntimeException("Service seeker not found");
        }
    }

}


