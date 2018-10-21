package edu.utcn.a2.servicelayer;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import edu.utcn.a2.datalayer.CityDAO;
import edu.utcn.a2.entities.City;

public class CityService {

	private CityDAO cityDAO;
	
	public CityService() {
		cityDAO = new CityDAO();
	}
	
	public ArrayList<City> getAllCities() {
		return cityDAO.getAllCities();
	}
	
	public City getCity(String name) {
		return cityDAO.getCity(name);
	}
	
	public String addCity(String name, String latitude, String longitude) {
		City city = cityDAO.getCity(name);
		if (city == null) {
			city = new City();
			city.setName(name);
			city.setLatitude(latitude);
			city.setLongitude(longitude);
			cityDAO.addCity(city);
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String updateCity(String name, String latitude, String longitude) {
		City city = cityDAO.getCity(name);
		if (city != null) {
			city.setLatitude(latitude);
			city.setLongitude(longitude);
			cityDAO.updateCity(city);
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String deleteCity(String name) {
		City city = cityDAO.getCity(name);
		if (city != null) {
			cityDAO.deleteCity(city);
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String getLocalTime(String name) {
		City city = cityDAO.getCity(name);
		try {
			String urlString = "http://www.new.earthtools.org/timezone-1.1/" + city.getLatitude() + "/" + city.getLongitude();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			SAXBuilder saxBuilder = new SAXBuilder();
			Document jdomDoc = saxBuilder.build(conn.getInputStream());
			Element e = jdomDoc.getRootElement().getChild("localtime");
			return e.getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
