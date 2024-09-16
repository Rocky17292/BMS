package com.bms.BookMyShow.Service;

import java.lang.module.ResolutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.BookMyShow.Entity.Movie;
import com.bms.BookMyShow.Repository.MovieRepo;

@Service
public class MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	public String addMovie(Movie movie) {
		movieRepo.save(movie);
		return "movie added successfully.";
	}

	public Movie getMovie(int id) throws ResolutionException{
		return movieRepo.findById(id).orElseThrow(()-> new ResolutionException("Movie with id: "+id+ " not found."));
	}
}
