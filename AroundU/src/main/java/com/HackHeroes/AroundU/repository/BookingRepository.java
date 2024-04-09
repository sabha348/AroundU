package com.HackHeroes.AroundU.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HackHeroes.AroundU.entity.Booking;
import com.HackHeroes.AroundU.entity.ServiceProvider;
import com.HackHeroes.AroundU.entity.ServiceSeeker;

public interface BookingRepository extends JpaRepository<Booking,Integer>{
	
	
	@Query("SELECT b FROM Booking b WHERE b.serviceProvider=:provider and b.serviceDate=:serviceDate and b.bookingStatus='BOOKED'")
	List<Booking> getProviderBookingForDate(ServiceProvider provider, LocalDateTime serviceDate);
	
	@Query("SELECT b FROM Booking b WHERE b.serviceProvider=:provider and b.serviceSeeker=:seeker and b.serviceDate=:serviceDate and b.bookingStatus='BOOKED'")
	List<Booking> getProviderBookingForDateAndSeeker(ServiceProvider provider,ServiceSeeker seeker, LocalDateTime serviceDate);
	
	
	 @Query("SELECT b FROM Booking b WHERE b.serviceProvider.serviceprovider_id = :serviceProviderId")
	    List<Booking> findAllByServiceProviderId(@Param("serviceProviderId") int serviceProviderId);
	 
	 @Query("SELECT b FROM Booking b WHERE b.serviceSeeker.serviceseeker_id = :serviceSeekerId")
	    List<Booking> findAllByServiceSeekerId(@Param("serviceSeekerId") int serviceSeekerId);

}

