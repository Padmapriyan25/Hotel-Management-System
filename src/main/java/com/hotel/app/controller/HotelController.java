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

import com.hotel.app.dto.Hotel;
import com.hotel.app.service.HotelService;
import com.hotel.app.utilities.ResponseStructure;

@RestController
@RequestMapping("/hotel")
public class HotelController 
{
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/saveHotel")
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(@RequestBody Hotel hotel)
	{
		return hotelService.saveHotel(hotel);
	}
	
	@PostMapping("/saveHotels")
	public ResponseEntity<ResponseStructure<String>> saveHotels(@RequestBody List<Hotel> hotels)
	{
		return hotelService.saveHotels(hotels);
	}
	
	@PutMapping("/updateHotel")
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(@RequestBody Hotel hotel, @RequestParam int hotelId)
	{
		return hotelService.updateHotel(hotel, hotelId);
	}
	
	@GetMapping("/getHotelById")
	public ResponseEntity<ResponseStructure<Hotel>> getHotelById(@RequestParam int hotelId)
	{
		return hotelService.getHotelById(hotelId);
	}
	
	@GetMapping("/getAllHotels")
	public ResponseEntity<ResponseStructure<List<Hotel>>> getAllHotels()
	{
		return hotelService.getAllHotels();
	}
	
	@DeleteMapping("/deleteHotel")
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(@RequestParam int hotelId)
	{
		return hotelService.deleteHotel(hotelId);
	}

}
