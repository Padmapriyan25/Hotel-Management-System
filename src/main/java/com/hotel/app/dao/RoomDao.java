package com.hotel.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.app.dto.Room;
import com.hotel.app.repository.RoomRepo;

@Repository
public class RoomDao 
{
	@Autowired
	private RoomRepo roomRepo;

	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public Room getRoomById(int roomId) {
		return roomRepo.findById(roomId).get();
	}
	
	public Room updateRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public void deleteRoom(int roomId) {
		roomRepo.deleteById(roomId);
	}
	public List<Room> getAllRooms(){
		return roomRepo.findAll();
	}
}
