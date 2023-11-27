/**
 * 
 */
package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exception.*;

/**
 * 
 */
public interface UserDao {
	
	public void registerCustomer(Customer customer);
	
	public void registerGymOwner(GymOwner gymOwner);
	
	public void registerUser(User user);
	
	public List<User> viewAllCustomers();
	
	public List<User> viewAllGymOwners();
	
	public User getAdmin();

	public User authenticateUser(User user);
	
}
