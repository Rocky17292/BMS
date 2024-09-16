package com.bms.BookMyShow.Entity;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("startTime")
	private LocalTime startTime;
	@JsonProperty("endTime")
	private LocalTime endTime;
	@JsonProperty("movieName")
	private String movieName;
	@JsonProperty("theaterName")
	private String theaterName;
	@JsonProperty("price")
	private int price;

	public Ticket(String userName, LocalTime startTime, LocalTime endTime, String movieName, String theaterName,
			int price) {
		super();
		this.userName = userName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
