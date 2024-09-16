package com.bms.BookMyShow.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bms.BookMyShow.Entity.Movie;
import com.bms.BookMyShow.Entity.Show;
import com.bms.BookMyShow.Entity.Theater;
import com.bms.BookMyShow.Entity.Ticket;
import com.bms.BookMyShow.Exception.ResourceNotFoundException;
import com.bms.BookMyShow.Repository.MovieRepo;
import com.bms.BookMyShow.Repository.ShowRepo;
import com.bms.BookMyShow.Repository.TheaterRepo;
import com.bms.BookMyShow.Repository.TicketRepo;

@Service
public class TheaterService {

	@Autowired
	private TheaterRepo theaterRepo;
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private ShowRepo showRepo;

	@Autowired
	private TicketRepo ticketRepo;
	
	public String addTheater(Theater theater) {
		Boolean[] seats = new Boolean[theater.getNoOfSeat()];
		theater.setSeats(seats);
		for(int i=0; i<seats.length; i++) {
			seats[i] = true;
		}
		theaterRepo.save(theater);
		return "Theater added successfully.";
	}

	public ResponseEntity<String> associateMovieAndTheater(int movieId, int theaterId) {

        Optional<Movie> optionalMovie = movieRepo.findById(movieId);
        Optional<Theater> optionalTheater = theaterRepo.findById(theaterId);

        if (optionalMovie.isEmpty()) {
            return new ResponseEntity<>("Movie with ID " + movieId + " not found.", HttpStatus.NOT_FOUND);
        }

        if (optionalTheater.isEmpty()) {
            return new ResponseEntity<>("Theater with ID " + theaterId + " not found.", HttpStatus.NOT_FOUND);
        }

        Movie movie = optionalMovie.get();
        Theater theater = optionalTheater.get();    
        
        theater.setMovie(movie);
        theaterRepo.save(theater);

        return new ResponseEntity<>("Movie and Theater are associated successfully.", HttpStatus.OK);
    }

	public ResponseEntity<?> bookSeat(int movieId, int theaterId, int showId,String name,int seatNo) {
		Optional<Movie> movie = movieRepo.findById(movieId);
		Optional<Theater> theater = theaterRepo.findById(theaterId);
		Optional<Show> show = showRepo.findById(showId);
		
		if(movie.isEmpty()) {
			return new ResponseEntity<>("movie with id: " + movieId + " is not available.",HttpStatus.NOT_FOUND);
		}
		if(theater.isEmpty()) {
			return new ResponseEntity<>("theater with id: " + theaterId + " is not available.",HttpStatus.NOT_FOUND);
		}
		if(show.isEmpty()) {
			return new ResponseEntity<>("show with id: " + showId + " is not available.",HttpStatus.NOT_FOUND);
		}		
		
		Movie movieModel = movie.get();
		Show showModel = show.get();
		Theater theaterModel = theater.get();
		
		Boolean[] seats = theaterModel.getSeats();
		
		if(!seats[seatNo]) {
			return new ResponseEntity<>("Seat with seat number :" + seatNo + " is not available.", HttpStatus.NOT_FOUND);
		}
		
		Ticket ticket = new Ticket(name,showModel.getStartTime(),showModel.getEndTime(),movieModel.getTitle(),theaterModel.getName(),250);
		
		ticketRepo.save(ticket);
		
		return new ResponseEntity<>(ticket,HttpStatus.OK);
	}
}
