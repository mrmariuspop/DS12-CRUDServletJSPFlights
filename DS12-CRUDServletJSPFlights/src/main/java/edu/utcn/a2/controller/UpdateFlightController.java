package edu.utcn.a2.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.utcn.a2.entities.City;
import edu.utcn.a2.entities.Flight;
import edu.utcn.a2.servicelayer.CityService;
import edu.utcn.a2.servicelayer.FlightService;

@WebServlet("/UpdateFlightController")
public class UpdateFlightController extends HttpServlet {

	private static final long serialVersionUID = 1;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		CityService cityService = new CityService();
		ArrayList<City> cities = cityService.getAllCities();
		request.setAttribute("departurecities", cities);
		request.setAttribute("arrivalcities", cities);
		
		FlightService flightService = new FlightService();
		Flight flight = flightService.getFlightById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("airplanetype", flight.getAirplane_type());
		request.setAttribute("dcity", flight.getDeparture_city());
		request.setAttribute("departuredh", flight.getDeparture_date_hour());
		request.setAttribute("acity", flight.getArrival_city());
		request.setAttribute("arrivaldh", flight.getArrival_date_hour());
		
		HttpSession session = request.getSession(false);
		session.setAttribute("fid", request.getParameter("id"));
		
		request.getRequestDispatcher("/updateflight.jsp").forward(request, response);
		return;
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int id = Integer.parseInt((String)session.getAttribute("fid"));
		session.removeAttribute("fid");
		
		if (request.getParameter("update") != null) {
			String airplane_type = request.getParameter("airplane_type");
			String departure_city = request.getParameter("departure_city");
			String departure_date_hour = request.getParameter("departure_date");
			String arrival_city = request.getParameter("arrival_city");
			String arrival_date_hour = request.getParameter("arrival_date");
			
			if (departure_city.equals(arrival_city)) {
				request.setAttribute("err", "Departure city and arrrival city are the same");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			try {
				Date departure = sdf.parse(departure_date_hour);
				Date arrival = sdf.parse(arrival_date_hour);
				
				if (departure.after(arrival)) {
					request.setAttribute("err", "Departure date after arrival date");
					request.getRequestDispatcher("error.jsp").forward(request, response);
					return;
				}
			} catch (ParseException e1) {
				request.setAttribute("err", "Invalid dates");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			
			FlightService flightService = new FlightService();
			try {
				flightService.updateFlight(id, airplane_type, departure_city, departure_date_hour, arrival_city, arrival_date_hour);
			} catch (Exception e) {
				request.setAttribute("err", "Invalid data");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			ArrayList<Flight> flights = flightService.getAllFlights();
			request.setAttribute("flights", flights);
			request.getRequestDispatcher("adminflights.jsp").forward(request, response);
			return;	
		}
		
		if (request.getParameter("back") != null) {
			FlightService flightService = new FlightService();
			ArrayList<Flight> flights = flightService.getAllFlights();
			request.setAttribute("flights", flights);
			request.getRequestDispatcher("adminflights.jsp").forward(request, response);
			return;
		}
	}
}
