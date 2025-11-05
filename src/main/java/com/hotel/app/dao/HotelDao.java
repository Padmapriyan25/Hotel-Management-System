package com.hotel.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.app.dto.Hotel;
import com.hotel.app.repository.HotelRepo;

@Repository
public class HotelDao 
{
	@Autowired
	private HotelRepo hotelRepo;
	
	public Hotel saveHotel(Hotel hotel)
	{
		return hotelRepo.save(hotel);
	}
	
	public Hotel updateHotel(Hotel hotel)
	{
		return hotelRepo.save(hotel);
	}
	
	public Hotel deleteHotel(int hotelId)
	{
		if(hotelRepo.findById(hotelId).isPresent()) 
		{
			Hotel hotel = hotelRepo.findById(hotelId).get();
			hotelRepo.delete(hotel);
			return hotel;
		}
		return null;
	}
	
	public void deleteHotelById(int hotelId)
	{
		hotelRepo.deleteById(hotelId);
	}
	
	public Hotel getHotelById(int hotelId)
	{
		if(hotelRepo.findById(hotelId).isPresent())
		{
			return hotelRepo.findById(hotelId).get();
		}
		return null;
	}
	
	public List<Hotel> getAllHotel()
	{
		return hotelRepo.findAll();
	}
	
	public List<Hotel> saveHotels(List<Hotel> hotels)
	{
		for(Hotel h:hotels) hotelRepo.save(h);
		return hotels;
	}
}
