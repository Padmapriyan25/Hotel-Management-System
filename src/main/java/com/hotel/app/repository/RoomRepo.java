package com.hotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.app.dto.Room;

public interface RoomRepo extends JpaRepository<Room, Integer>
{
	
}
