package com.hotel.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.app.dao.HotelDao;
import com.hotel.app.dao.RoomDao;
import com.hotel.app.dto.Hotel;
import com.hotel.app.dto.Room;
import com.hotel.app.exception.IdNotFoundException;
import com.hotel.app.utilities.ResponseStructure;

@Service
public class RoomService 
{
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private HotelDao hotelDao;
	
	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room,int hotelId)
	{
		Hotel hotel = hotelDao.getHotelById(hotelId);
		if(hotel != null) {
			room.setHotel(hotel);
			ResponseStructure<Room> responseStructure = new ResponseStructure<>();
			room.setHotel(hotel);
			responseStructure.setData(roomDao.saveRoom(room));
			responseStructure.setMessage("Room created successfully");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.CREATED);
			
		}
		throw new IdNotFoundException("No Hotel with id " + hotelId + " exist !");
	}

	public ResponseEntity<ResponseStructure<Room>> updateRoom(Room room,int roomId)
	{
		Room toUpdate = roomDao.getRoomById(roomId);
		if(toUpdate != null) {
			toUpdate.setRoom_id(roomId);
			ResponseStructure<Room> responseStructure = new ResponseStructure<>();
			responseStructure.setData(roomDao.updateRoom(room));
			responseStructure.setMessage("Room nomber " + room.getRoom_no() + " has been updated successfully");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
			
		}
		throw new IdNotFoundException("No Room with id " + roomId + " exist !");
	}
	
	public ResponseEntity<ResponseStructure<Room>> getRoomById(int roomId) {
		Room room = roomDao.getRoomById(roomId);
		if(room != null) {
			ResponseStructure<Room> responseStructure = new ResponseStructure<>();
			responseStructure.setData(room);
			responseStructure.setMessage("Welcome to room number " + room.getRoom_id() + "!!!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.FOUND);
		}
		throw new IdNotFoundException("No Room with id " + roomId + " exist !");
	}
	
	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(int roomId){
		Room room = roomDao.getRoomById(roomId);
		if(room != null) {
			ResponseStructure<Room> responseStructure = new ResponseStructure<>();
			responseStructure.setData(room);
			responseStructure.setMessage(room.getRoom_id() + " has been deleted succesfully");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			roomDao.deleteRoom(roomId);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("No Room with id " + roomId + " exist !");
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRooms(){
		List<Room> list = roomDao.getAllRooms();
		if(list != null) {
			ResponseStructure<List<Room>> responseStructure = new ResponseStructure<>();
			responseStructure.setData(list);
			responseStructure.setMessage(list.size() + " rooms have been fetched!!!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.FOUND);
		}
		throw new IdNotFoundException("No Rooms Available !");
	}
	
}
