package com.jsp.CloneApIBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApIBookMyShow.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
