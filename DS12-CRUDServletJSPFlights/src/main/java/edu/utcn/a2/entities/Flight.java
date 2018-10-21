package edu.utcn.a2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "airplane_type", nullable = false)
	private String airplane_type;
	@Column(name = "departure_city", nullable = false)
	private String departure_city;
	@Column(name = "departure_date_hour", nullable = false)
	private String departure_date_hour;
	@Column(name = "arrival_city", nullable = false)
	private String arrival_city;
	@Column(name = "arrival_date_hour", nullable = false)
	private String arrival_date_hour;

	public Flight() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAirplane_type() {
		return airplane_type;
	}
	
	public void setAirplane_type(String airplane_type) {
		this.airplane_type = airplane_type;
	}
	
	public String getDeparture_city() {
		return departure_city;
	}
	
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	
	public String getDeparture_date_hour() {
		return departure_date_hour;
	}
	
	public void setDeparture_date_hour(String departure_date_hour) {
		this.departure_date_hour = departure_date_hour;
	}
	
	public String getArrival_city() {
		return arrival_city;
	}
	
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	
	public String getArrival_date_hour() {
		return arrival_date_hour;
	}
	
	public void setArrival_date_hour(String arrival_date_hour) {
		this.arrival_date_hour = arrival_date_hour;
	}
}
