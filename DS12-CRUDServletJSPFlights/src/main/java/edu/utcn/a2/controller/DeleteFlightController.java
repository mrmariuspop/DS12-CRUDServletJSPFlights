package edu.utcn.a2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.utcn.a2.entities.Flight;
import edu.utcn.a2.servicelayer.FlightService;

@WebServlet("/DeleteFlightController")
public class DeleteFlightController extends HttpServlet {

	private static final long serialVersionUID = 1;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		FlightService flightService = new FlightService();
        flightService.deleteFlight(Integer.parseInt(request.getParameter("id")));   
		ArrayList<Flight> flights = flightService.getAllFlights();
		request.setAttribute("flights", flights);
		request.getRequestDispatcher("adminflights.jsp").forward(request, response);
		return;
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
