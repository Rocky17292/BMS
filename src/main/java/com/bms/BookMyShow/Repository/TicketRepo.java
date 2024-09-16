package com.bms.BookMyShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.BookMyShow.Entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{

}
