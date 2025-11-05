package com.hotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.app.dto.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>
{
	
}
