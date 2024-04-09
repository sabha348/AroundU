package com.HackHeroes.AroundU.entity;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer historyId;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seeker_id", referencedColumnName = "seeker_id")
    private ServiceSeeker serviceSeeker;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_provider_id", referencedColumnName = "serviceProviderid")
    private ServiceProvider serviceProvider;


    @Column(name = "service_date")
    private LocalDateTime serviceDate;
    
    public String getBookingStatus() {
		return bookingStatus;
	}



	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Column(name = "booking_date")
    private LocalDateTime bookingDate = LocalDateTime.now();
    
    @Column(name = "booking_status")
    private String bookingStatus;
	
    public Booking(Integer historyId, ServiceSeeker serviceSeeker, ServiceProvider serviceProvider,
			LocalDateTime serviceDate, LocalDateTime bookingDate) {
		super();
		this.historyId = historyId;
		this.serviceSeeker = serviceSeeker;
		this.serviceProvider = serviceProvider;
		this.serviceDate = serviceDate;
		this.bookingDate = bookingDate;
	}

	

    public Booking(ServiceSeeker serviceSeeker, ServiceProvider serviceProvider,
			LocalDateTime serviceDate, String bookingStatus) {
		super();
		this.serviceSeeker = serviceSeeker;
		this.serviceProvider = serviceProvider;
		this.serviceDate = serviceDate;
		this.bookingStatus = bookingStatus;
	}
	public Booking(Integer historyId, ServiceSeeker serviceSeeker, ServiceProvider serviceProvider,
			LocalDateTime serviceDate, String bookingStatus) {
		super();
		this.historyId = historyId;
		this.serviceSeeker = serviceSeeker;
		this.serviceProvider = serviceProvider;
		this.serviceDate = serviceDate;
		this.bookingStatus = bookingStatus;
	}

	public Booking() {
        
    }

	public Integer getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	public ServiceSeeker getServiceSeeker() {
		return serviceSeeker;
	}

	public void setServiceSeeker(ServiceSeeker serviceSeeker) {
		this.serviceSeeker = serviceSeeker;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}


	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public LocalDateTime getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(LocalDateTime serviceDate) {
		this.serviceDate = serviceDate;
	}



	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

}