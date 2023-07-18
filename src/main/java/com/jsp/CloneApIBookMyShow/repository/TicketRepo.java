package com.jsp.CloneApIBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApIBookMyShow.entity.Ticket;

public interface TicketRepo  extends JpaRepository<Ticket, Long>{

}
