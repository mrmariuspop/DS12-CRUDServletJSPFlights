package edu.utcn.a2.dto;

public class FlightDTO {

	private int id;
	private String airplane_type;
	private String departure_city;
	private String departure_city_local_time;
	private String departure_date_hour;
	private String arrival_city;
	private String arrival_city_local_time;
	private String arrival_date_hour;

	public FlightDTO() {
		
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
	
	public String getDeparture_city_local_time() {
		return departure_city_local_time;
	}
	
	public void setDeparture_city_local_time(String departure_city_local_time) {
		this.departure_city_local_time = departure_city_local_time;
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
	
	public String getArrival_city_local_time() {
		return arrival_city_local_time;
	}
	
	public void setArrival_city_local_time(String arrival_city_local_time) {
		this.arrival_city_local_time = arrival_city_local_time;
	}
	
	public String getArrival_date_hour() {
		return arrival_date_hour;
	}
	
	public void setArrival_date_hour(String arrival_date_hour) {
		this.arrival_date_hour = arrival_date_hour;
	}
}
