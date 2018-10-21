package edu.utcn.a2.util;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.utcn.a2.dto.FlightDTO;
import edu.utcn.a2.servicelayer.FlightService;

@WebFilter("/*")
public class AccessFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession(false);
        
        boolean loginRequest = request.getRequestURI().equals(request.getContextPath() + "/") || request.getRequestURI().equals(request.getContextPath() + "/LoginController");
        boolean adminRequest = request.getRequestURI().indexOf("Add") >= 0 || request.getRequestURI().indexOf("Update") >= 0 || request.getRequestURI().indexOf("Delete") >= 0;
        
        if (session != null) {
        	if (loginRequest) {
        		arg2.doFilter(request, response);
        	} else {
        		if (session.getAttribute("role") != null) {
        			if (session.getAttribute("role").equals("user") && adminRequest) {
        				FlightService flightService = new FlightService();
        				ArrayList<FlightDTO> flightsDTO = flightService.getAllFlightsDTO();
        				request.setAttribute("flights", flightsDTO);
    					request.getRequestDispatcher("userflights.jsp").forward(request, response);
    					return;
        			} else {
        				arg2.doFilter(request, response);
        			}
        		} else {
        			request.getRequestDispatcher("login.jsp").forward(request, response);
        			return;
        		}
            }
        } else {
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        	return;
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
