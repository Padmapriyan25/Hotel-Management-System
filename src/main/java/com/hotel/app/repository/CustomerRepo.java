package com.hotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.app.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>
{

}
