package com.hotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.app.dto.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>
{

}
