package com.bms.BookMyShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.BookMyShow.Entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>{

}
