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

import com.hotel.app.dto.Customer;
import com.hotel.app.service.CustomerService;
import com.hotel.app.utilities.ResponseStructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer, @RequestParam int customerId){
		return customerService.updateCustomer(customer, customerId);
	}
	
	@GetMapping("/getCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam int customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId){
		return customerService.deleteCustomer(customerId);
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers(){
		return customerService.getAllCustomers();
	}

	@PostMapping("/saveAllCustomers")
	public ResponseEntity<ResponseStructure<String>> saveAllCustomers(@RequestBody List<Customer> customers) {
	    return customerService.SaveCustomers(customers);
	}
}
