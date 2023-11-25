/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.*;

/**
 * 
 */
public class UserBusiness implements UserBusinessInterface{

	List<User> userList = new ArrayList<>();

	public UserBusiness(){
		User u1 = new User();
		u1.setEmail("asmi@flipfit");
		u1.setRoleId(1);
		u1.setPassword("12345");

		User u2 = new User();
		u2.setEmail("arav@flipfit");
		u2.setRoleId(2);
		u2.setPassword("Hello");

		User u3 = new User();
		u3.setEmail("harsha@flipfit");
		u3.setRoleId(3);
		u3.setPassword("1234567");

		userList.add(u1);
		userList.add(u2);
		userList.add(u3);


	}

	/**

	 Registers a customer in the database.
	 @param customer The Customer object representing the customer data
	 */
	public void registerCustomer(Customer customer) {

		System.out.println("Customer registered");
	}

	/**
	 * Returns the Admin from the list of Users
	 */
	public User getAdmin()
	{

		for(int i=0;i<userList.size();i++)
		{
			if(userList.get(i).getRoleId() == 1)
				return userList.get(i);
		}
		return null;
	}

	/**
	 * View all the customers which are in the list of users
	 * @return List of all the customers
	 */
	public List<User> viewAllCustomers()
	{
		List<User>allCustomers = new ArrayList<>();
		for(int i=0;i<userList.size();i++)
		{
			if(userList.get(i).getRoleId() == 3)
				allCustomers.add(userList.get(i));
		}
		return allCustomers;
	}

	/**
	 * View all the Gym Owners which are in the list of users
	 * @return List of all the Gym Owners
	 */
	public List<User> viewAllGymOwners()
	{
		List<User>allGymOwners = new ArrayList<>();
		for(int i=0;i<userList.size();i++)
		{
			if(userList.get(i).getRoleId() == 2)
				allGymOwners.add(userList.get(i));
		}
		return allGymOwners;
	}

	/**

	 Registers a GymOwner in the database.
	 @param gymOwner The gymOwner object representing the gym owner data
	 */
	public void registerGymOwner(GymOwner gymOwner) {
		System.out.println("GymOwner registered");
	}

	/**

	 Authenticates a user based on the provided user data.
	 @param user The User object representing the user data
	 */
	public void login(User user) {
		System.out.println("Logged in successfully");
	}

	/**

	 Logs out a user.
	 @param user The User object representing the user data
	 */
	public void logout(User user) {
		System.out.println("LoggedOut in successfully");
	}

	/**

	 Registers a user in the database.
	 @param user The User object representing the user data
	 */
	public void registerUser(User user) {
		System.out.println("User registered");
	}
}
