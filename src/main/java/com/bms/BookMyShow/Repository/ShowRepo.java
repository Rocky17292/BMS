package com.bms.BookMyShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.BookMyShow.Entity.Show;

public interface ShowRepo extends JpaRepository<Show, Integer>{

}
