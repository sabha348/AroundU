package com.HackHeroes.AroundU.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.HackHeroes.AroundU.entity.ServiceProvider;
import com.HackHeroes.AroundU.entity.dao.ServiceProviderDTO;
import com.HackHeroes.AroundU.repository.SearchServiceRepository;
import com.HackHeroes.AroundU.service.Searchservice;

@Service
public class Searchserviceimpl implements Searchservice{
	
	
    private SearchServiceRepository searchservicerepository;

    public Searchserviceimpl(SearchServiceRepository searchservicerepository) {
        this.searchservicerepository = searchservicerepository;
    }

    @Override
    public List<ServiceProviderDTO> searchprovider(String query) {
        List<ServiceProviderDTO> providerDTOList = new ArrayList<>();
        System.out.println(query);
        List<ServiceProvider> providerList = searchservicerepository.searchprovider(query);
        for (ServiceProvider provider : providerList) {
            ServiceProviderDTO dto = new ServiceProviderDTO();
            dto.setName(provider.getName());
            dto.setService(provider.getService());
            providerDTOList.add(dto);
            System.out.println(dto);
        }
        return providerDTOList;
    }
	
	 
	 



}





   

	
   




	
	



