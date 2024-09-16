package com.bms.BookMyShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.BookMyShow.Entity.Movie;
import com.bms.BookMyShow.Service.MovieService;

@RestController
@RequestMapping("/bms/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/admin/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie){
		return ResponseEntity.ok(movieService.addMovie(movie));
	}
	
	@GetMapping("/getMovie")
	public ResponseEntity<?> getMovie(@RequestParam("id") int id){
		try {			
			return ResponseEntity.ok(movieService.getMovie(id));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie with id :"+ id + " not found.");
		}
	}
}
