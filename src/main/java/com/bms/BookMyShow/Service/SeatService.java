package com.bms.BookMyShow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.BookMyShow.Entity.Seat;
import com.bms.BookMyShow.Repository.SeatRepo;

@Service
public class SeatService {

	@Autowired
	private SeatRepo seatRepo;
	
	public String addSeat(Seat seat) {
		seatRepo.save(seat);
		return "seat added successfully.";
	}
}
