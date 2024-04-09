package com.HackHeroes.AroundU.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HackHeroes.AroundU.entity.Booking;
import com.HackHeroes.AroundU.entity.ServiceProvider;
import com.HackHeroes.AroundU.entity.ServiceSeeker;
import com.HackHeroes.AroundU.repository.BookingRepository;
import com.HackHeroes.AroundU.repository.ServiceProviderRepository;
import com.HackHeroes.AroundU.repository.ServiceSeekerRepository;

@Service
public class BookingService {
	 @Autowired
	  private ServiceProviderRepository serviceProviderRepository;
	  @Autowired
	  private ServiceSeekerRepository serviceSeekerRepository;
	  
	  @Autowired
	  private BookingRepository bookingRepository;
	  
	  
	  

	  public void bookService(int seeker_id, int provider_id, LocalDateTime serviceTime) {
	     
	      Optional<ServiceProvider> optionalProvider = serviceProviderRepository.findById(provider_id);
	      if(!optionalProvider.isPresent()) {
	          throw new RuntimeException("Provider not found");
	      }
	      
	    
	      Optional<ServiceSeeker> optionalSeeker = serviceSeekerRepository.findById(seeker_id);
	      if(!optionalSeeker.isPresent()) {
	          throw new RuntimeException("Seeker not found");
	      }
	      
	    
	      if(LocalDateTime.now().isAfter(serviceTime)) {
	          throw new RuntimeException("You can only book future slots.");
	      }
	      
	     
	      List<Booking> existingBookings = bookingRepository.getProviderBookingForDate(optionalProvider.get(), serviceTime);
	      if(!existingBookings.isEmpty()) {
	          throw new RuntimeException("Provider is already booked for this slot");
	      }
	      
	      
	      Booking booking = new Booking(optionalSeeker.get(), optionalProvider.get(), serviceTime, "BOOKED");
	      bookingRepository.save(booking);
	  }
	  
	  public List<Booking> getAllServicesByServiceProviderId(int serviceProviderId) {
	      return bookingRepository.findAllByServiceProviderId(serviceProviderId);
	  }
	  
	  
	  public List<Booking> getAllServicesByServiceSeekerId(int serviceSeekerId) {
	      return bookingRepository.findAllByServiceSeekerId(serviceSeekerId);
	  }
	  
	  public void cancelBooking(int bookingId) {
	     
	      Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
	      if (!optionalBooking.isPresent()) {
	          throw new RuntimeException("Booking not found");
	      }

	    
	      Booking booking = optionalBooking.get();

	    
	      if (booking.getBookingStatus().equals("CANCELLED")) {
	          throw new RuntimeException("Booking is already cancelled");
	      }

	   
	      booking.setBookingStatus("CANCELLED");
	      bookingRepository.save(booking);
	  }
	  public void updateBookingStatus(int bookingId,String updatestatus)
	  {
	  	
	      Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
	      if (!optionalBooking.isPresent()) {
	          throw new RuntimeException("Booking not found");
	      }

	      
	      Booking booking = optionalBooking.get();

	    
	      if (booking.getBookingStatus().equals(updatestatus)) {
	          throw new RuntimeException("Booking is already" + updatestatus);
	      }

	      
	      booking.setBookingStatus(updatestatus);
	      bookingRepository.save(booking);
	  	
	  	
	  }

}







