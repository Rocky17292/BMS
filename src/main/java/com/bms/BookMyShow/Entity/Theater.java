package com.bms.BookMyShow.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("location")
	private String location;

	@JoinColumn
	@ManyToOne
	@JsonProperty("Movie_id")
	private Movie movie;

	@JsonProperty("noOfSeat")
	private int noOfSeat;

	@JsonProperty("seats")
	private Boolean seats[];

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public Boolean[] getSeats() {
		return seats;
	}

	public void setSeats(Boolean[] seats) {
		this.seats = seats;
	}

}
