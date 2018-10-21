package edu.utcn.a2.datalayer;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.utcn.a2.entities.City;
import edu.utcn.a2.entities.Flight;
import edu.utcn.a2.util.HibernateConfig;

public class FlightDAO {

	private Session session = HibernateConfig.getSessionFactory().openSession();
	
	public FlightDAO() {
		
	}
	
	public ArrayList<Flight> getAllFlights() {
		Query query = session.createQuery("From Flight");
		session.beginTransaction();
		ArrayList<Flight> flights = (ArrayList<Flight>)query.list();
		session.getTransaction().commit();
		return flights;
	}
	
	public Flight getFlightById(int id) {
		session.beginTransaction();
		Flight flight = (Flight)session.get(Flight.class, id);	
		session.getTransaction().commit();
		return flight;
	}
	
	public void addFlight(Flight flight) {
		session.beginTransaction();
		session.save(flight);
		session.getTransaction().commit();
	}
	
	public void updateFlight(Flight flight) {
		session.beginTransaction();
		session.update(flight);
		session.getTransaction().commit();
	}
	
	public void deleteFlight(Flight flight) {
		session.beginTransaction();
		session.delete(flight);
		session.getTransaction().commit();
	}
	
	public void close() {
		session.close();
		HibernateConfig.shutdown();
	}
}
