package com.HackHeroes.AroundU.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HackHeroes.AroundU.entity.ServiceSeeker;
import com.HackHeroes.AroundU.service.AddSeekerservice;

@RestController
public class ServiceSeekerController {

    private AddSeekerservice addSeekerservice;

    @Autowired
    public ServiceSeekerController( AddSeekerservice serviceSeekerService) {
        this.addSeekerservice = serviceSeekerService;
    }

    @PostMapping("/api/service-seekers")
    public ResponseEntity<ServiceSeeker> createServiceSeeker(@RequestBody ServiceSeeker serviceSeeker) {
        ServiceSeeker createdServiceSeeker = addSeekerservice.createServiceSeeker(serviceSeeker);
        return new ResponseEntity<>(createdServiceSeeker, HttpStatus.CREATED);
    }
}