/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.*;
import com.flipkart.bean.*;
import java.util.*;

/**
 * 
 */
public class GMSCustomerClient {

	CustomerBusiness customerBusiness = new CustomerBusiness();
	Customer customer = new Customer();
	
	
	public void customerRegistration(Scanner sc) {
		System.out.println("Enter your name: ");
		customer.setName(sc.next());
		System.out.println("Enter your mobile: ");
		customer.setPhone(sc.nextLong());
		System.out.println("Enter your email: ");
		customer.setEmail(sc.next());
		System.out.println("Enter your address: ");
		customer.setAddress(sc.next());
		System.out.println("Enter your password: ");
		String password = sc.next();
		User user = new User();
		user.setPassword(password);
		user.setEmail(customer.getEmail());
		user.setRoleId(3);
		UserBusiness userBusiness = new UserBusiness();
//		UserBusiness.registerUser(user);
//		UserBusiness.registerCustomer(customer);
	}
	
	public void bookSlot(Scanner sc,String customerEmail) {
		
	}
	
	public void cancelBookedSlot(String customerEmail) {
		
	}
	
	public void viewAllBookedSlots(String customerEmail) {
		
	}
	
	public void customerPage(Scanner sc, String customerEmail) {
		
		while(true) {
			System.out.println("1. Book slot");
			System.out.println("2. Cancel Booked slot");
			System.out.println("3. View all booked Slots");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				bookSlot(sc,customerEmail);
				break;
			case 2:
				cancelBookedSlot(customerEmail);
				break;
			case 3:
				viewAllBookedSlots(customerEmail);
			case 4:
				GMSApplicationClient.mainPage();
				break;
			default:
				System.out.println("Incorrect choice");
			}
		}
			
		
	}

}
