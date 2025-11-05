package com.hotel.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.app.dto.Booking;
import com.hotel.app.repository.BookingRepo;

@Repository
public class BookingDao 
{
	@Autowired
	private BookingRepo bookingRepo;
	
	public Booking saveBooking(Booking booking)
	{
		return bookingRepo.save(booking);
	}
	
	public Booking updateBooking(Booking booking)
	{
		return bookingRepo.save(booking);
	}
	
	public Booking getBookingById(int bookingId)
	{
		return bookingRepo.findById(bookingId).get();
	}
	
	public List<Booking> getAllBooking()
	{
		return bookingRepo.findAll();
	}
	
	public void deleteBookingById(int bookingId)
	{
		bookingRepo.deleteById(bookingId);
	}
}
