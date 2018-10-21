package edu.utcn.a2.datalayer;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import edu.utcn.a2.entities.User;
import edu.utcn.a2.util.HibernateConfig;

public class UserDAO {
	
	private Session session = HibernateConfig.getSessionFactory().openSession();
	
	public UserDAO() {
		
	}
	
	public ArrayList<User> getAllUsers() {
		Query query = session.createQuery("From User");
		session.beginTransaction();
		ArrayList<User> users = (ArrayList<User>)query.list();
		session.getTransaction().commit();
		return users;
	}
	
	public User getUserById(int id) {
		session.beginTransaction();
		User user = (User)session.get(User.class, id);	
		session.getTransaction().commit();
		return user;
	}
	
	public User getUserByUserName(String username) {
		session.beginTransaction();
		String query = "SELECT * FROM user where username = :username";
		SQLQuery q = session.createSQLQuery(query);
		q.addEntity(User.class);
		q.setParameter("username", username);
		User user = ((ArrayList<User>)q.list()).get(0);	
		session.getTransaction().commit();
		return user;
	}
	
	public void addUser(User user) {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	public void updateUser(User user) {
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	
	public void deleteUser(User user) {
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	
	public void close() {
		session.close();
		HibernateConfig.shutdown();
	}
}
