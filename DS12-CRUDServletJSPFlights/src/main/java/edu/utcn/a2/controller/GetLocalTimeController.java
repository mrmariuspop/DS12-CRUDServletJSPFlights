package edu.utcn.a2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.utcn.a2.dto.FlightDTO;
import edu.utcn.a2.servicelayer.FlightService;

@WebServlet("/GetLocalTimeController")
public class GetLocalTimeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		FlightService flightService = new FlightService();
		ArrayList<FlightDTO> flightsDTO = flightService.getAllFlightsDTO();
		request.setAttribute("flights", flightsDTO);
		request.getRequestDispatcher("userflights.jsp").forward(request, response);		
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
	}
}
