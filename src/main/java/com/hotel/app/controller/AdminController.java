package com.hotel.app.controller;

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
import com.hotel.app.dto.Admin;
import com.hotel.app.service.AdminService;
import com.hotel.app.utilities.ResponseStructure;

@RestController
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin, @RequestParam int hotelId)
	{
		return adminService.saveAdmin(admin, hotelId);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin, @RequestParam int hotelId)
	{
		return adminService.updateAdmin(admin, hotelId);
	}
	
	@GetMapping("/getAdminById")
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@RequestParam int adminId)
	{
		return adminService.getAdminById(adminId);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int adminId)
	{
		return adminService.deleteAdminById(adminId);
	}
}
