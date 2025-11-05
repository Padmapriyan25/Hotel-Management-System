package com.hotel.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hotel.app.dto.Admin;
import com.hotel.app.repository.AdminRepo;

@Repository
public class AdminDao 
{
	@Autowired
	private AdminRepo adminRepo;
	
	public Admin saveAdmin(Admin admin)
	{
		return adminRepo.save(admin);
	}

	public Admin updateAdmin(Admin admin)
	{
		return adminRepo.save(admin);
	}

	public Admin getAdminById(int adminId)
	{
		return adminRepo.findById(adminId).get();
	}

	public void deleteAdminById(int adminId) 
	{
		adminRepo.deleteById(adminId);
	}
}
