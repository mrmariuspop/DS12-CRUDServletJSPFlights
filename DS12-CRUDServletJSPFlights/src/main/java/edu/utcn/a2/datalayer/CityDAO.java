package edu.utcn.a2.datalayer;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.utcn.a2.entities.City;
import edu.utcn.a2.util.HibernateConfig;

public class CityDAO {

	private Session session = HibernateConfig.getSessionFactory().openSession();
	
	public CityDAO() {
		
	}
	
	public ArrayList<City> getAllCities() {
		Query query = session.createQuery("From City");
		session.beginTransaction();
		ArrayList<City> cities = (ArrayList<City>)query.list();
		session.getTransaction().commit();
		return cities;
	}
	
	public City getCity(String name) {
		session.beginTransaction();
		City city = (City)session.get(City.class, name);	
		session.getTransaction().commit();
		return city;
	}
	
	public void addCity(City city) {
		session.beginTransaction();
		session.save(city);
		session.getTransaction().commit();
	}
	
	public void updateCity(City city) {
		session.beginTransaction();
		session.update(city);
		session.getTransaction().commit();
	}
	
	public void deleteCity(City city) {
		session.beginTransaction();
		session.delete(city);
		session.getTransaction().commit();
	}
	
	public void close() {
		session.close();
		HibernateConfig.shutdown();
	}
}
