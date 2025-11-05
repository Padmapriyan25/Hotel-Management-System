package com.hotel.app.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Room 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;

	private String room_no;
	private String room_type;
	private int room_price;
	private int no_beds;
	private int max_people;
	private String availability;
	
	@OneToOne(mappedBy = "room")
	private Booking booking;
	
	@ManyToOne
	private Hotel hotel;
}
