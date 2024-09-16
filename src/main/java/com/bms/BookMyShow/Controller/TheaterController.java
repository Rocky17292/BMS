package com.bms.BookMyShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.BookMyShow.Entity.Theater;
import com.bms.BookMyShow.Service.TheaterService;

@RestController
@RequestMapping("/bms/theater")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;
	
	@PostMapping("/admin/addTheater")
	public ResponseEntity<?> addTheater(@RequestBody Theater theater){
		String response = theaterService.addTheater(theater);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/admin/associateMovieAndTheater")
	public ResponseEntity<?> associateMovieAndTheater(@RequestParam ("Movie_Id") int movieId,
			                                          @RequestParam("Theater_Id") int theaterId){
		return theaterService.associateMovieAndTheater(movieId,theaterId);
	}
	
	
	@GetMapping("/user/bookSeat")
	public ResponseEntity<?> bookSeat(@RequestParam ("Movie_Id") int movieId,
			                                          @RequestParam("Theater_Id") int theaterId,
			                                          @RequestParam ("showId") int showId,
			                                          @RequestParam ("name") String name,
			                                          @RequestParam ("seatNo") int seatNo){
		return theaterService.bookSeat(movieId,theaterId,showId,name,seatNo);
	}
}
