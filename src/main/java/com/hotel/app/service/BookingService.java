package com.hotel.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.app.dao.BookingDao;
import com.hotel.app.dao.CustomerDao;
import com.hotel.app.dao.RoomDao;
import com.hotel.app.dto.Booking;
import com.hotel.app.dto.Customer;
import com.hotel.app.dto.Room;
import com.hotel.app.exception.IdNotFoundException;
import com.hotel.app.exception.RoomFullException;
import com.hotel.app.exception.RoomNotAvailableException;
import com.hotel.app.utilities.ResponseStructure;

@Service
public class BookingService 
{
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private RoomDao roomDao;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking, int customerId, int roomId)
	{
		Room room = roomDao.getRoomById(roomId);
		Customer customer = customerDao.getCustomerById(customerId);
		if(room == null) throw new IdNotFoundException("No room id such as " + roomId + "!!!");
		if(customer == null) throw new IdNotFoundException("No customer id such as " + customerId + "!!!");
		if(room.getAvailability().equalsIgnoreCase("N")) throw new RoomNotAvailableException("This room is already booked!!!");
		if(booking.getNo_people() > room.getMax_people()) throw new RoomFullException("Too many people for this room, sorry!!!");
		room.setAvailability("N");
		booking.setRoom(roomDao.updateRoom(room));
		booking.setCustomer(customer);
		booking.setCheck_in_date(LocalDateTime.now());
		ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
		responseStructure.setData(bookingDao.saveBooking(booking));
		responseStructure.setMessage("You have booked room number " + room.getRoom_no() + " successfully!!!");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking, int bookingId)
	{
		Booking BookingUp = bookingDao.getBookingById(bookingId);
		if(BookingUp != null)
		{
			if(booking.getNo_people() <= booking.getRoom().getMax_people()) {
				booking.setId(bookingId);
				booking.setCheck_in_date(BookingUp.getCheck_in_date());
				booking.setCheck_out_date(BookingUp.getCheck_out_date());
				booking.setCustomer(BookingUp.getCustomer());
				booking.setRoom(BookingUp.getRoom());
				ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
				responseStructure.setData(bookingDao.updateBooking(booking));
				responseStructure.setMessage("You have updated your booking " + bookingId + " successfully!!!");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);
			}
			else
				throw new RoomFullException("Too many people for this room");
		}
		else
			throw new IdNotFoundException("No booking_id such as " + bookingId + "!!!");
	}
	
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int bookingId)
	{
		Booking booking = bookingDao.getBookingById(bookingId);
		if(booking != null)
		{
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setData(booking);
			responseStructure.setMessage("Booking id has been found " + bookingId);
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Id not found");
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking()
	{
		List<Booking> list = bookingDao.getAllBooking();
		if(list != null) {
			ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();
			responseStructure.setData(list);
			responseStructure.setMessage(list.size() + " bookings have been fatched!!!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(responseStructure, HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Id not found");
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBookingById(int bookingId)
	{
		Booking booking = bookingDao.getBookingById(bookingId);
		if(booking != null) {
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setData(booking);
			responseStructure.setMessage("Booking id " + bookingId + " deleted !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			bookingDao.getBookingById(bookingId);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Booking id not found");
	}
	
	public ResponseEntity<ResponseStructure<Booking>> closeBooking(int bookingId, int rating){
		Booking booking = bookingDao.getBookingById(bookingId);
		if(booking != null) {
			Room room = booking.getRoom();
			room.setAvailability("Y");
			booking.setRating(rating);
			booking.setRoom(roomDao.updateRoom(room));
			booking.setCheck_out_date(LocalDateTime.now());
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setData(bookingDao.updateBooking(booking));
			responseStructure.setMessage("Booking closed successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK); 
		}
		throw new IdNotFoundException("Booking id not found");
	}
}