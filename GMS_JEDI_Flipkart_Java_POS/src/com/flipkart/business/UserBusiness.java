/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

/**
 * 
 */
public class UserBusiness {

	public void registerCustomer(Customer customer) {
		System.out.println("Customer registered");
	}
	
	
	public void registerGymOwner(GymOwner gymOwner) {
		System.out.println("GymOwner registered");
	}
	
	public void login(User user) {
		System.out.println("Logged in successfully");
	}
	
	public void logout(User user) {
		System.out.println("LoggedOut in successfully");
	}
	
	public void registerUser() {
		System.out.println("User registered");
	}
}
