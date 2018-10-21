package edu.utcn.a2.servicelayer;

import java.util.ArrayList;

import edu.utcn.a2.datalayer.FlightDAO;
import edu.utcn.a2.dto.FlightDTO;
import edu.utcn.a2.entities.Flight;

public class FlightService {

	private FlightDAO flightDAO;
	
	public FlightService() {
		flightDAO = new FlightDAO();
	}
	
	public ArrayList<Flight> getAllFlights() {
		return flightDAO.getAllFlights();
	}
	
	public ArrayList<FlightDTO> getAllFlightsDTO() {
		CityService cityService = new CityService();
		ArrayList<Flight> flights = flightDAO.getAllFlights();
		ArrayList<FlightDTO> flightsDTO = new ArrayList<FlightDTO>();
		for (Flight f : flights) {
			FlightDTO dto = new FlightDTO();
			dto.setId(f.getId());
			dto.setAirplane_type(f.getAirplane_type());
			dto.setDeparture_city(f.getDeparture_city());
			dto.setDeparture_city_local_time(cityService.getLocalTime(f.getDeparture_city()));
			dto.setDeparture_date_hour(f.getDeparture_date_hour());
			dto.setArrival_city(f.getArrival_city());
			dto.setArrival_city_local_time(cityService.getLocalTime(f.getArrival_city()));
			dto.setArrival_date_hour(f.getArrival_date_hour());
			flightsDTO.add(dto);
		}
		return flightsDTO;
	}
	
	public Flight getFlightById(int id) {
		return flightDAO.getFlightById(id);
	}
	
	public void addFlight(String airplane_type, String departure_city, String departure_date_hour, String arrival_city, String arrival_date_hour) {
		Flight flight = new Flight();
		flight.setAirplane_type(airplane_type);
		flight.setDeparture_city(departure_city);
		flight.setDeparture_date_hour(departure_date_hour);
		flight.setArrival_city(arrival_city);
		flight.setArrival_date_hour(arrival_date_hour);
		flightDAO.addFlight(flight);
	}
	
	public void updateFlight(int id, String airplane_type, String departure_city, String departure_date_hour, String arrival_city, String arrival_date_hour) {
		Flight flight = flightDAO.getFlightById(id);
		flight.setAirplane_type(airplane_type);
		flight.setDeparture_city(departure_city);
		flight.setArrival_city(arrival_city);
		flight.setArrival_date_hour(arrival_date_hour);
		flightDAO.updateFlight(flight);
	}
	
	public void deleteFlight(int id) {
		Flight flight = flightDAO.getFlightById(id);
		flightDAO.deleteFlight(flight);
	}
}
