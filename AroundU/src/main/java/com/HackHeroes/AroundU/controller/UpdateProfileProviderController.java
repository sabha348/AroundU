package com.HackHeroes.AroundU.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HackHeroes.AroundU.entity.ServiceProvider;
import com.HackHeroes.AroundU.service.UpdateProfileProviderservice;


@RestController
@RequestMapping("/api/service-providers")
public class UpdateProfileProviderController {
	
	@Autowired
	private UpdateProfileProviderservice serviceProviderService;
	
	 @PutMapping("/update-profile")
	    public void updateServiceSeekerProfile(@RequestParam int id, @RequestBody ServiceProvider updatedServiceProvider) {
	        serviceProviderService.updateServiceProviderProfile(id, updatedServiceProvider);
	    }

}


