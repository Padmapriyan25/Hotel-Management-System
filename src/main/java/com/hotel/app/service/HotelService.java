package com.hotel.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.app.dao.HotelDao;
import com.hotel.app.dto.Hotel;
import com.hotel.app.exception.IdNotFoundException;
import com.hotel.app.utilities.ResponseStructure;

@Service
public class HotelService 
{
	@Autowired
	private HotelDao hotelDao;
	
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(Hotel hotel)
	{
		ResponseStructure<Hotel> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Hotel has been Saved successfully !");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(hotelDao.saveHotel(hotel));
		
		return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(Hotel hotel, int hotelId)
	{
		Hotel hotelUp = hotelDao.getHotelById(hotelId);
		if(hotelUp != null)
		{
			ResponseStructure<Hotel> responseStructure = new ResponseStructure<>();
			hotel.setHotel_id(hotelId);
			responseStructure.setMessage("Hotel updated successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hotelDao.updateHotel(hotel));
			
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Not hotel with " + hotelId + " found !");
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(int hotelId)
	{
		Hotel hotel = hotelDao.getHotelById(hotelId);
		if(hotel != null)
		{
			ResponseStructure<Hotel> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Hotel " + hotel.getHotel_id() + " has been Deleted successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hotel);
			hotelDao.deleteHotel(hotelId);
			
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Not hotel with " + hotelId + " found !");
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> getHotelById(int hotelId) {
		Hotel hotel  = hotelDao.getHotelById(hotelId);
		if(hotel != null) {
			ResponseStructure<Hotel> responseStructure = new ResponseStructure<>();
			responseStructure.setData(hotel);
			responseStructure.setMessage("Wellcome to " + hotel.getHotel_name() + "!'");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Not hotel with " + hotelId + " found !");
	}
	
	public ResponseEntity<ResponseStructure<List<Hotel>>> getAllHotels()
	{
		List<Hotel> list = hotelDao.getAllHotel();
		if(list != null)
		{
			ResponseStructure<List<Hotel>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage(list.size() + " Hotels have been listed successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(list);
			
			return new ResponseEntity<ResponseStructure<List<Hotel>>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Not hotels found !");
	}
	
	public ResponseEntity<ResponseStructure<String>> saveHotels(List<Hotel> hotels)
	{		
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Hotels have been created successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hotelDao.saveHotels(hotels).size() + "hotels have been saved !");
			
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	}
}
