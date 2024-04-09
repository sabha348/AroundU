package com.HackHeroes.AroundU.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HackHeroes.AroundU.entity.Booking;
import com.HackHeroes.AroundU.entity.BookingRequest;
import com.HackHeroes.AroundU.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	
	 @Autowired
	    private BookingService bookingService;

	    
	     @PostMapping("/book")
	    public ResponseEntity<String> bookSlot(@RequestBody BookingRequest bookingRequest) {
	        try {  
	        	LocalDateTime serviceTime = LocalDateTime.parse(bookingRequest.serviceTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	            bookingService.bookService(bookingRequest.seekerId, bookingRequest.providerId, serviceTime);
	            return ResponseEntity.ok("Slot booked successfully");
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
	    
	    @GetMapping("/service-provider/{serviceProviderId}")
	    public ResponseEntity<List<Booking>> getAllServicesByServiceProviderId(@PathVariable int serviceProviderId) {
	        List<Booking> bookings = bookingService.getAllServicesByServiceProviderId(serviceProviderId);
	        return ResponseEntity.ok(bookings);
	    }
	    
	    
	    
	    @GetMapping("/service-seeker/{serviceSeekerId}")
	    public ResponseEntity<List<Booking>> getAllServicesByServiceSeekerId(@PathVariable int serviceSeekerId) {
	        List<Booking> bookings = bookingService.getAllServicesByServiceSeekerId(serviceSeekerId);
	        return ResponseEntity.ok(bookings);
	    }
	    
	    
	    @DeleteMapping("/cancel/{bookingId}")
	    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
	        try {
	            bookingService.cancelBooking(bookingId);
	            return ResponseEntity.ok("Booking cancelled successfully");
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
	    
	    

	    @PutMapping("booking-status")
	    public void updateBookingStatus(@RequestParam int id, @RequestBody String updatestatus) {
	    	bookingService.updateBookingStatus(id,updatestatus);
	    }
}



