package com.hotel.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.app.dto.Booking;
import com.hotel.app.service.BookingService;
import com.hotel.app.utilities.ResponseStructure;

@RestController
@RequestMapping("/booking")
public class BookingController
{
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/saveBooking")
	public ResponseEntity<ResponseStructure<Booking>> saveAdmin(@RequestBody Booking booking, @RequestParam int customerId, @RequestParam int roomId)
	{
		return bookingService.saveBooking(booking, customerId, roomId);
	}
	
	@PutMapping("/updateBooking")
	public ResponseEntity<ResponseStructure<Booking>> updateAdmin(@RequestBody Booking booking, @RequestParam int bookingId)
	{
		return bookingService.updateBooking(booking, bookingId);
	}
	
	@GetMapping("/getBookingById")
	public ResponseEntity<ResponseStructure<Booking>> getAdminById(@RequestParam int bookingId)
	{
		return bookingService.getBookingById(bookingId);
	}
	
	@GetMapping("/getAllBookings")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllHotels()
	{
		return bookingService.getAllBooking();
	}
	
	@DeleteMapping("/deleteBooking")
	public ResponseEntity<ResponseStructure<Booking>> deleteAdmin(@RequestParam int bookingId)
	{
		return bookingService.deleteBookingById(bookingId);
	}
	
	@PutMapping("/closeBooking")
	public ResponseEntity<ResponseStructure<Booking>> closeBooking( @RequestParam int bookingId, @RequestParam int rating) {
		return bookingService.closeBooking(bookingId,rating);

	}
}
