/**
 * 
 */
package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.*;
import com.flipkart.client.*;

/**
 * 
 */
public class GMSApplicationClient {

	UserBusiness user = new UserBusiness();

	private boolean check_Admin_Authentication(String username, String password)
	{
		User admin = user.getAdmin();
		if(admin.getEmail() == username && admin.getPassword() == password)
			return true;
		return false;
	}

	private boolean check_customer_authentication(String username, String password)
	{
		List<User>customerList = user.viewAllCustomers();
		for(int i=0;i<customerList.size();i++)
		{
			if(customerList.get(i).getEmail() == username && customerList.get(i).getPassword == password)
			{
				return true;
			}
		}
		return false;
	}

	private boolean check_gymOwner_authentication(String username, String password)
	{
		List<User>gymOwnerList = user.viewAllGymOwners();
		for(int i=0;i<gymOwnerList.size();i++)
		{
			if(gymOwnerList.get(i).getEmail() == username && gymOwnerList.get(i).getPassword == password)
			{
				return true;
			}
		}
		return false;
	}

	public static void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String username = sc.next();
		System.out.println("Enter your correct password: ");
		String password = sc.next();
		System.out.println("Enter your role: ");
		String role = sc.next();
		switch (role) {

			case "Customer":
				if(check_customer_authentication(username,password))
				{
					GMSCustomerClient customer = new GMSCustomerClient();
					customer.customerPage(sc, username);
				}
				else
				{
					System.out.println("Invalid Customer");
				}
			    break;
		    case "GymOwner":
				if(check_gymOwner_authentication(username,password))
				{
					GMSGymOwnerClient gymOwner = new GMSGymOwnerClient();
					gymOwner.gymOwnerPage(sc, username);
				}
				else
				{
					System.out.println("Invalid GymOwner");
				}
				break;
		    case "Admin":
				if(check_Admin_Authentication(username,password)) {
					GMSAdminClient admin = new GMSAdminClient();
					admin.adminPage(sc);
				}
				else
					System.out.println("Invalid Admin");
				break;

		case "Customer":

			GMSCustomerClient customer = new GMSCustomerClient();
			customer.customerPage(sc, username);
			break;
		case "GymOwner":
			GMSGymOwnerClient gymOwner = new GMSGymOwnerClient();
			gymOwner.gymOwnerPage(sc, username);
			break;
		case "Admin":
			GMSAdminClient admin = new GMSAdminClient();
			admin.adminPage(sc);
			break;

		}
//		User user = new User();
//		user.setEmail(username);
//		user.setPassword(password);
	}
	
	public static void mainPage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to FlipFit Application");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Customer Registration");
		System.out.println("3. GymOwner Registration");
		System.out.println("4. exit");
		Scanner sc = new Scanner(System.in);
		
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			login();
			break;
		case 2:
			GMSCustomerClient Customer = new GMSCustomerClient();
			Customer.customerRegistration(sc);
			System.out.println("Please Login");
			login();
			break;
		case 3:
			GMSGymOwnerClient Owner = new GMSGymOwnerClient();
			Owner.registerGymOwner(sc);
			System.out.println("Please Login");
			login();
			break;
		case 4:
			System.out.println("Exiting.....");
			System.exit(0);
			break;
		default: 
			System.out.println("Wrong choice");
			mainPage();
		}
	}

	public static void main(String[] args) throws Exception {
		mainPage();
	}
}
