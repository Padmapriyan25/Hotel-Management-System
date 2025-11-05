package com.hotel.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.app.dto.Customer;
import com.hotel.app.repository.CustomerRepo;

@Repository
public class CustomerDao 
{
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer saveCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	
	public Customer updateCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	
	public Customer getCustomerById(int customerId)
	{
		return customerRepo.findById(customerId).get();
	}
	
	public List<Customer> getAllCustomer()
	{
		return customerRepo.findAll();
	}
	
	public void deleteCustomerById(int customerId)
	{
		customerRepo.deleteById(customerId);
	}
	
	public List<Customer> saveCustomers(List<Customer> customers)
	{
		for(Customer c:customers) customerRepo.save(c);
		return customers;
	}
}
