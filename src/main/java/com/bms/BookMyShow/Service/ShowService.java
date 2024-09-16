package com.bms.BookMyShow.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bms.BookMyShow.Entity.Movie;
import com.bms.BookMyShow.Entity.Show;
import com.bms.BookMyShow.Entity.Theater;
import com.bms.BookMyShow.Repository.MovieRepo;
import com.bms.BookMyShow.Repository.ShowRepo;
import com.bms.BookMyShow.Repository.TheaterRepo;

@Service
public class ShowService {

	@Autowired
	private ShowRepo showRepo;
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private TheaterRepo theaterRepo;
	
	public String addShow(Show show) {
		showRepo.save(show);
		return "show has been saved successfully.";
	}

	public ResponseEntity<?> associateTheaterShowAndMovie(int showId, int movieId, int theaterId) {
		Optional<Movie> movie =  movieRepo.findById(movieId);
		Optional<Theater> theater = theaterRepo.findById(theaterId);
		Optional<Show> show = showRepo.findById(showId);
		
		if(movie.isEmpty()) {
			return new ResponseEntity<>("movie with id: " + movieId + " not found.",HttpStatus.NOT_FOUND);
		}
		if(show.isEmpty()) {
			return new ResponseEntity<>("show with id: " + showId + " not found.",HttpStatus.NOT_FOUND);
		}
		if(theater.isEmpty()) {
			return new ResponseEntity<>("theater with id: " + theaterId + " not found.",HttpStatus.NOT_FOUND);
		}
		
		Show showModel = show.get();
		Theater theaterModel = theater.get();
		Movie movieModel = movie.get();
		
		showModel.setMovie(movieModel);
		showModel.setTheater(theaterModel);
		showRepo.save(showModel);
		return new ResponseEntity<>("movie,theater and show are associated successfully.",HttpStatus.OK);
	}
}
