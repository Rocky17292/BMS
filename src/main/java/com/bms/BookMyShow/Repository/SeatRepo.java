package com.bms.BookMyShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.BookMyShow.Entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>{

}
