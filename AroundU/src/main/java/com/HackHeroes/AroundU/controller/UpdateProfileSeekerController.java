package com.HackHeroes.AroundU.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HackHeroes.AroundU.entity.ServiceSeeker;
import com.HackHeroes.AroundU.service.UpdateProfileSeekerservice;


@RestController
@RequestMapping("/api/service-seekers")
public class UpdateProfileSeekerController {
	
	 @Autowired
	    private UpdateProfileSeekerservice serviceSeekerService;

	    @PutMapping("/update-profile")
	    public void updateServiceSeekerprofile(@RequestParam int id, @RequestBody ServiceSeeker updatedServiceSeeker) {
	        serviceSeekerService.updateServiceSeekerProfile(id, updatedServiceSeeker);
	    }

}
