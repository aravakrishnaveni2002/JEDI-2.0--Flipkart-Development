/**
 * 
 */
package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.*;
import com.flipkart.client.*;
import com.flipkart.business.*;
import com.flipkart.exception.UserNotFoundException;

/**
 * 
 */
public class GMSApplicationClient {

	public static final String ANSI_YELLOW = "\u001B[33m";
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

	public static void login() throws Exception{
		Scanner sc = new Scanner(System.in);
		UserBusiness userBusiness = new UserBusiness();
		System.out.println("Enter your user email: ");
		String username = sc.next();
		System.out.println("Enter your correct password: ");
		String password = sc.next();
		System.out.println("Enter your role name: ");
		String role = sc.next();

		User user = new User();
		user.setEmail(username);
		user.setPassword(password);
		if(role.equals("Customer")){
			user.setRoleId(3);
		}
		else if(role.equals("GymOwner")){
			user.setRoleId(2);
		}
		else if(role.equals("Admin")){
			user.setRoleId(1);
		}
		try{
			user = userBusiness.authenticateUser(user);
			switch(user.getRoleId()) {
				case 3:
					GMSCustomerClient customer = new GMSCustomerClient();
					customer.customerPage(sc, user.getEmail());

					break;
				case 2:
					GMSGymOwnerClient gymOwner = new GMSGymOwnerClient();
					gymOwner.gymOwnerPage(sc, user.getEmail());
					break;
				case 1:
					GMSAdminClient admin = new GMSAdminClient();
					admin.adminPage(sc);
					break;
			}

		} catch(UserNotFoundException ue){
			System.out.println(ANSI_RED + ue.getMessage() + ANSI_RESET);
			mainPage();
		}
	}
	
	public static void mainPage() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ANSI_YELLOW + "Welcome to FlipFit Application \n ------------------------------ \n Menu: \n 1. Login \n 2. Customer Registration \n 3. GymOwner Registration \n 4. exit \n ------------------------------" + ANSI_RESET);
//		System.out.println("Welcome to FlipFit Application");
//		System.out.println("------------------------------");
//		System.out.println("Menu:");
//		System.out.println("1. Login");
//		System.out.println("2. Customer Registration");
//		System.out.println("3. GymOwner Registration");
//		System.out.println("4. exit");
//		System.out.println("------------------------------");
		Scanner sc = new Scanner(System.in);

		try {
			int choice = sc.nextInt();

			switch (choice) {
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
		} catch (InputMismatchException excep) {
			System.out.println("Please give relevant input!");
			mainPage();
		}
	}
	public static void main(String[] args) throws Exception {
		mainPage();
	}
}
