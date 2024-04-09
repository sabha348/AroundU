package com.HackHeroes.AroundU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HackHeroes.AroundU.entity.ServiceSeeker;
import com.HackHeroes.AroundU.repository.ServiceSeekerRepository;

@Service
public class AddSeekerservice {
	
	

    private  ServiceSeekerRepository serviceSeekerRepository;

    @Autowired
    public AddSeekerservice(ServiceSeekerRepository serviceSeekerRepository) {
        this.serviceSeekerRepository = serviceSeekerRepository;
    }

    @Transactional
    public ServiceSeeker createServiceSeeker(ServiceSeeker serviceSeeker) {
        return serviceSeekerRepository.save(serviceSeeker);
    }

}

