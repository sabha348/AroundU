package com.HackHeroes.AroundU.service;

import java.util.List;

import com.HackHeroes.AroundU.entity.dao.ServiceProviderDTO;

public interface Searchservice {
	
	List<ServiceProviderDTO> searchprovider(String query);

}