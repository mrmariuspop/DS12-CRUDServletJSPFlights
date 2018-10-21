package edu.utcn.a2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.utcn.a2.dto.FlightDTO;
import edu.utcn.a2.entities.Flight;
import edu.utcn.a2.servicelayer.FlightService;
import edu.utcn.a2.servicelayer.UserService;

@WebServlet("/")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		String user_name = request.getParameter("username");
		String pass = request.getParameter("password");
		String result = userService.login(user_name, pass);
		
		if (result.equals("invalid username")) {
			request.setAttribute("err", "Invalid username");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		else {
			if (result.equals("invalid password")) {
				request.setAttribute("err", "Invalid password");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			else {
				FlightService flightService = new FlightService();
				ArrayList<Flight> flights = flightService.getAllFlights();
				ArrayList<FlightDTO> flightsDTO = flightService.getAllFlightsDTO();
				HttpSession session = request.getSession();
				session.setAttribute("role", result);
				if (result.equals("user")) {
					request.setAttribute("flights", flightsDTO);
					request.getRequestDispatcher("userflights.jsp").forward(request, response);
					return;
				}
				if (result.equals("admin")) {
					request.setAttribute("flights", flights);
					request.getRequestDispatcher("adminflights.jsp").forward(request, response);
					return;
				}
			}
		}
	}
}