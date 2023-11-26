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
	UserDao userImpl = new UserDaoImpl();
	/**
	 Registers a customer in the database.
	 @param customer The Customer object representing the customer data
	 */
	public void registerCustomer(Customer customer) {
		System.out.println("Customer registered");
		userImpl.registerCustomer(customer);
	}

	/**
	 * Returns the Admin from the list of Users
	 */
	public User getAdmin()
	{
		return userImpl.getAdmin();
	}

	/**
	 * View all the customers which are in the list of users
	 * @return List of all the customers
	 */
	public List<User> viewAllCustomers()
	{
		System.out.println("Listing all customers");
		return userImpl.viewAllCustomers();
	}

	/**
	 * View all the Gym Owners which are in the list of users
	 * @return List of all the Gym Owners
	 */
	public List<User> viewAllGymOwners()
	{
		System.out.println("Listing all Gym Owners");
		return userImpl.viewAllGymOwners();
	}

	/**

	 Registers a GymOwner in the database.
	 @param gymOwner The gymOwner object representing the gym owner data
	 */
	public void registerGymOwner(GymOwner gymOwner) {
		System.out.println("GymOwner registered");
		userImpl.registerGymOwner(gymOwner);
	}

	public void registerUser(User user) {
		System.out.println("User registered");
		userImpl.registerUser(user);
	}
}
