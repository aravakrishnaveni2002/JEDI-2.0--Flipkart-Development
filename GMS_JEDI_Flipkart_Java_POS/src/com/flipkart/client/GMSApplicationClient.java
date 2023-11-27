/**
 * 
 */
package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.*;
import com.flipkart.client.*;
import com.flipkart.business.*;

/**
 * 
 */
public class GMSApplicationClient {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	private static boolean check_Admin_Authentication(UserBusiness userBusiness, String username, String password)
	{
		User admin = userBusiness.getAdmin();
		if(admin.getEmail().equals(username) && admin.getPassword().equals(password))
			return true;
		return false;
	}

	private static boolean check_customer_authentication(UserBusiness userBusiness, String username, String password)
	{
		List<User>customerList = userBusiness.viewAllCustomers();
		for(int i=0;i<customerList.size();i++)
		{
			if(customerList.get(i).getEmail().equals(username) && customerList.get(i).getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}

	private static boolean check_gymOwner_authentication(UserBusiness userBusiness, String username, String password)
	{
		List<User>gymOwnerList = userBusiness.viewAllGymOwners();
		for(int i=0;i<gymOwnerList.size();i++)
		{
			if(gymOwnerList.get(i).getEmail().equals(username) && gymOwnerList.get(i).getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}

	public static void login() {
		Scanner sc = new Scanner(System.in);
		UserBusiness userBusiness = new UserBusiness();
		System.out.println("Enter your user email: ");
		String username = sc.next();
		System.out.println("Enter your correct password: ");
		String password = sc.next();
		System.out.println("Enter your role name: ");
		String role = sc.next();
		switch (role) {

			case "Customer":
				if(check_customer_authentication(userBusiness,username,password))
				{
					GMSCustomerClient customer = new GMSCustomerClient();
					customer.customerPage(sc, username);
				}
				else
				{
					System.out.println(ANSI_RED + "Invalid Customer" + ANSI_RESET);
					login();
				}
			    break;
		    case "GymOwner":
				if(check_gymOwner_authentication(userBusiness,username,password))
				{
					GMSGymOwnerClient gymOwner = new GMSGymOwnerClient();
					gymOwner.gymOwnerPage(sc, username);
				}
				else
				{
					System.out.println(ANSI_RED + "Invalid GymOwner" + ANSI_RESET);
					login();
				}
				break;
		    case "Admin":
				if(check_Admin_Authentication(userBusiness,username,password)) {
					GMSAdminClient admin = new GMSAdminClient();
					admin.adminPage(sc);
				}
				else
					System.out.println(ANSI_RED + "Invalid Admin" + ANSI_RESET);
					login();
				break;
		}
	}
	
	public static void mainPage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to FlipFit Application");
		System.out.println("------------------------------");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Customer Registration");
		System.out.println("3. GymOwner Registration");
		System.out.println("4. exit");
		System.out.println("------------------------------");
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
			System.out.println(ANSI_RED + "Wrong Choice" + ANSI_RESET);
//			System.out.println("Wrong choice");
			mainPage();
		}
	}

	public static void main(String[] args) throws Exception {
		mainPage();
	}
}
