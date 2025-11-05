package com.hotel.app.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Hotel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;
	
	private String hotel_name;
	private String hotel_gst;
	private String hotel_address;
	private String hotel_manager;
	private String hotel_owner;
	private int hotel_rating;
	
	@OneToOne(mappedBy = "hotel")
	private Admin admin;
}
