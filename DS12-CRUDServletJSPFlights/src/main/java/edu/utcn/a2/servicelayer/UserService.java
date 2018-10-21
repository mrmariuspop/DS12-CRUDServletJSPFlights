package edu.utcn.a2.servicelayer;

import java.util.ArrayList;

import edu.utcn.a2.datalayer.UserDAO;
import edu.utcn.a2.entities.User;

public class UserService {

	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public ArrayList<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}
	
	public User getUserByUserName(String username) {
		return userDAO.getUserByUserName(username);
	}
	
	public String addUser(String name, String username, String password, String role) {
		User user = userDAO.getUserByUserName(username);
		if (user == null) {
			user = new User();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			userDAO.addUser(user);
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String updateUser(String name, String username, String password, String role) {
		User user = userDAO.getUserByUserName(username);
		if (user != null) {
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
			userDAO.updateUser(user);
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String deleteUser(String username) {
		User user = userDAO.getUserByUserName(username);
		if (user != null) {
			userDAO.deleteUser(user);
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	public String login(String username, String password) {
		User user = userDAO.getUserByUserName(username);
		if (user == null) {
			return "invalid username";
		}
		else {
			if (user.getPassword().equals(password)) {
				return user.getRole();
			}
			else {
				return "invalid password";
			}
		}
	}
}
