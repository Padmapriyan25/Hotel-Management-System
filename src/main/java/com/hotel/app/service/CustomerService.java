package com.hotel.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.app.dao.CustomerDao;
import com.hotel.app.dto.Customer;
import com.hotel.app.exception.IdNotFoundException;
import com.hotel.app.utilities.ResponseStructure;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer)
	{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Customer registered successfully !");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer, int customerId)
	{
		Customer customerUp = customerDao.getCustomerById(customerId);
		if(customerUp != null)
		{
			ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
			customer.setC_id(customerId);
			responseStructure.setMessage("Hotel updated successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.updateCustomer(customer));
			
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Not Customer with " + customerId + " found !");
	}
	
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int customerId)
	{
		Customer customer = customerDao.getCustomerById(customerId);
		if(customer != null)
		{
			ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Customer " + customer.getC_name() + " has been Deleted successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customer);
			customerDao.deleteCustomerById(customerId);
			
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("No Customer with " + customerId + " found !");
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int customerId) {
		Customer customer  = customerDao.getCustomerById(customerId);
		if(customer != null) {
			ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
			responseStructure.setData(customer);
			responseStructure.setMessage("Hello " + customer.getC_name() + "!'");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);
		}
		throw new IdNotFoundException("No Customer with " + customerId + " found !");
	}
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers()
	{
		List<Customer> list = customerDao.getAllCustomer();
		if(list != null)
		{
			ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage(list.size() + " Customer have been listed successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(list);
			
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Not Customers found !");
	}
	
	public ResponseEntity<ResponseStructure<String>> SaveCustomers(List<Customer> hotels)
	{		
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Customers have been created successfully !");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.saveCustomers(hotels).size() + "customers have been saved !");
			
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	}
}
