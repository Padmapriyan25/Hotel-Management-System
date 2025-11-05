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

import com.hotel.app.dto.Room;
import com.hotel.app.service.RoomService;
import com.hotel.app.utilities.ResponseStructure;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@PostMapping("/saveRoom")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room, @RequestParam int hotelId){
		return roomService.saveRoom(room,hotelId);
	}
	
	@PutMapping("/updateRoom")
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@RequestBody Room room, @RequestParam int roomId){
		return roomService.updateRoom(room,roomId);
	}
	
	@GetMapping("/getRoomById")
	public ResponseEntity<ResponseStructure<Room>> getRoomById(@RequestParam int roomId){
		return roomService.getRoomById(roomId);
	}
	
	@DeleteMapping("/deleteRoom")
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(@RequestParam int roomId){
		return roomService.deleteRoomById(roomId);
	}
	
	@GetMapping("/getAllRooms")
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRooms(){
		return roomService.getAllRooms();
	}
	
}
