package com.bms.BookMyShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bms.BookMyShow.Entity.Seat;
import com.bms.BookMyShow.Service.SeatService;

@Controller
@RequestMapping("/bms/admin")
public class SeatController {

	@Autowired
	private SeatService seatService;
	
	@PostMapping("/addSeat")
	public ResponseEntity<?> addSeat(@RequestBody Seat seat){
		String  response = seatService.addSeat(seat);
		return ResponseEntity.ok(response);
	}
}
