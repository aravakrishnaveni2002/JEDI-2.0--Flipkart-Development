/**
 * 
 */
package com.flipkart.business;
import com.flipkart.DAO.UserDao;
import com.flipkart.DAO.UserDaoImpl;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.*;

/**
 * 
 */
public class UserBusiness implements UserBusinessInterface{
	UserDao userDaoImpl = new UserDaoImpl();
	/**
	 Registers a customer in the database.
	 @param customer The Customer object representing the customer data
	 */
	public void registerCustomer(Customer customer) {
		userDaoImpl.registerCustomer(customer);
		System.out.println("Customer registered"); // Make this Green
	}

	/**
	 * Returns the Admin from the list of Users
	 */
	public User getAdmin()
	{
		return userDaoImpl.getAdmin();
	}

	/**
	 * View all the customers which are in the list of users
	 * @return List of all the customers
	 */
	public List<User> viewAllCustomers()
	{
//		System.out.println("Listing all customers");
		return userDaoImpl.viewAllCustomers();
	}

	/**
	 * View all the Gym Owners which are in the list of users
	 * @return List of all the Gym Owners
	 */
	public List<User> viewAllGymOwners()
	{
//		System.out.println("Listing all Gym Owners");
		return userDaoImpl.viewAllGymOwners();
	}

	/**

	 Registers a GymOwner in the database.
	 @param gymOwner The gymOwner object representing the gym owner data
	 */
	public void registerGymOwner(GymOwner gymOwner) {
		userDaoImpl.registerGymOwner(gymOwner);
		System.out.println("GymOwner registered"); //Make this Green
	}

	public void registerUser(User user) {
		userDaoImpl.registerUser(user);
		System.out.println("User registered"); //Make this Green
	}
}
