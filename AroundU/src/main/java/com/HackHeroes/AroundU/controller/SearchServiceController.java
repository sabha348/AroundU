package com.HackHeroes.AroundU.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HackHeroes.AroundU.entity.dao.ServiceProviderDTO;
import com.HackHeroes.AroundU.service.Searchservice;

@RestController
@RequestMapping("/api/providers")
public class SearchServiceController {
	
	
	
private Searchservice searchservice;
	
	public SearchServiceController(Searchservice searchservice)
	{
		this.searchservice=searchservice;
	}
	
	

	@GetMapping("/search")
	public ResponseEntity<List<ServiceProviderDTO>>searchprovider(@RequestParam("query")String query){
		
		System.out.println("Query: "+ query);
		return ResponseEntity.ok(searchservice.searchprovider(query));
	}

}


