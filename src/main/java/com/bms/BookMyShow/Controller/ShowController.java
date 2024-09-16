package com.bms.BookMyShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.BookMyShow.Entity.Show;
import com.bms.BookMyShow.Service.ShowService;

@RestController
@RequestMapping("/bms/admin")
public class ShowController {

	@Autowired
	private ShowService showService;
	
	@PostMapping("/addShow")
	public ResponseEntity<?> addShow(@RequestBody Show show){
		String response = showService.addShow(show);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/associateTheaterShowAndMovie")
	public ResponseEntity<?> addShow(@RequestParam ("showId") int showId,
			@RequestParam ("movieId") int movieId,
			@RequestParam ("theaterId") int theaterId){
		return showService.associateTheaterShowAndMovie(showId,movieId,theaterId); 
	}
}
