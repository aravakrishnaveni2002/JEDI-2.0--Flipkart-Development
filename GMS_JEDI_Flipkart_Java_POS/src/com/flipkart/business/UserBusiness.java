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
public class UserBusiness {

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
