package com.hotel.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.app.dao.AdminDao;
import com.hotel.app.dao.HotelDao;
import com.hotel.app.dto.Admin;
import com.hotel.app.dto.Hotel;
import com.hotel.app.exception.IdNotFoundException;
import com.hotel.app.utilities.ResponseStructure;

@Service
public class AdminService 
{
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private HotelDao hotelDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin, int hotelId)
	{
		Hotel hotel = hotelDao.getHotelById(hotelId);
		if(hotel != null)
		{
			admin.setHotel(hotel);
		
			ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Admin has been Saved successfully !");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(adminDao.saveAdmin(admin));
			
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException("Not hotel with " + hotelId + " found !");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int adminId) {
		Admin adminUp = adminDao.getAdminById(adminId);
		if(adminUp != null)
		{
		admin.setAdmin_id(adminId);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setData(adminDao.updateAdmin(admin));
		responseStructure.setMessage("Admin has been created successfully!!!");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id : " + adminId + " does not exist !");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int adminId) {
		Admin admin = adminDao.getAdminById(adminId);
		if(admin != null)
		{
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setData(admin);
		responseStructure.setMessage("Hello " + admin.getAdmin_name());
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Id : " + adminId + " does not exist !");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int adminId) {
		Admin admin = adminDao.getAdminById(adminId);
		if(admin != null) 
		{
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setData(admin);
		responseStructure.setMessage(admin.getAdmin_name() + " has been deleted successfully !");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		adminDao.getAdminById(adminId);
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id : " + adminId + " does not exist !");
	}

}
