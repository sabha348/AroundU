package com.HackHeroes.AroundU.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HackHeroes.AroundU.entity.ServiceProvider;


public interface SearchServiceRepository extends JpaRepository<ServiceProvider,Integer>{
	
	@Query("SELECT p FROM ServiceProvider p WHERE " + "p.name LIKE CONCAT('%', :query, '%') OR " + "p.service LIKE CONCAT('%', :query, '%')")
	List<ServiceProvider> searchprovider(String query);
	
	
}
