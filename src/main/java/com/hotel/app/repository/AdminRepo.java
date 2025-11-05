package com.hotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.app.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>
{
	
}
