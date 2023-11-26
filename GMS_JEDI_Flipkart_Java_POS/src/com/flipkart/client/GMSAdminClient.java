/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.AdminBusiness;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminBusinessInterface;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class GMSAdminClient {
		
	AdminBusinessInterface adminBusiness = new AdminBusiness();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public void approveGymOwnerRequest(Scanner sc) {
		System.out.println("Enter the gymOwner Id");
		int gymOwnerId = sc.nextInt();
		adminBusiness.approveGymOwnerRegistration(gymOwnerId);
	}
	
	public void approveGymRequest(Scanner sc) {
		System.out.println("Enter the gym Id");
		int gymId = sc.nextInt();
		adminBusiness.approveGymRegistration(gymId);
	}
	
	public void viewPendingGymRequests() {
		List<GymCenter> gyms = adminBusiness.viewPendingGymRequests();
		System.out.printf("%-8s\t", "Id");
		System.out.printf("%-8s\t", "Name");
		System.out.printf("%-8s\t", "Location");
		System.out.printf("%-8s\t", "No of Seats");
		System.out.printf("%-8s\t", "Email");
		System.out.printf("%-8s\t", "IsApproved");
		System.out.println();
		for(GymCenter gymCenter: gyms) {
			System.out.printf("%-8s\t", gymCenter.getId());
			System.out.printf("%-8s\t", gymCenter.getName());
			System.out.printf("%-8s\t", gymCenter.getLocation());
			System.out.printf("%-8s\t", gymCenter.getNoOfSeats());
			System.out.printf("%-8s\t", gymCenter.getGymOwnerEmail());
			
			if(gymCenter.isApproved())
			{
				System.out.printf("%-8s\t", ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.printf("%-8s\t", "Yes");
			}
			else
			{
				System.out.printf("%-8s\t", ANSI_RED + "No" + ANSI_RESET);
//				System.out.println(ANSI_RED + "No" + ANSI_RESET);
//				System.out.printf("%-8s\t", "No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewPendingGymOwnerRequests() {
		List<GymOwner> owners = adminBusiness.viewPendingGymOwnerRequests();
		System.out.printf("%-8s\t", "Id");
		System.out.printf("%-8s\t", "Address");
		System.out.printf("%-8s\t", "Email");
		System.out.printf("%-8s\t", "GST Number");
		System.out.printf("%-8s\t", "Name");
		System.out.printf("%-8s\t", "Phone");
		System.out.printf("%-8s\t", "IsApproved");
		System.out.println();
		for(GymOwner gymOwner: owners) {
			System.out.printf("%-8s\t", gymOwner.getId());
			System.out.printf("%-8s\t", gymOwner.getAddress());
			System.out.printf("%-8s\t", gymOwner.getEmail());
			System.out.printf("%-8s\t", gymOwner.getGstNumber());
			System.out.printf("%-8s\t", gymOwner.getName());
			System.out.printf("%-8s\t", gymOwner.getPhone());
			if(gymOwner.isApproved())
			{
				System.out.printf("%-8s\t", ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.println("Yes");
			}
			else
			{
				System.out.printf("%-8s\t", ANSI_RED + "No" + ANSI_RESET);
//				System.out.println(ANSI_RED + "No" + ANSI_RESET);
//				System.out.println("No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewAllGymCenters() {
		List<GymCenter> gyms = adminBusiness.viewAllApprovedGyms();
		System.out.printf("%-8s\t", "Id");
		System.out.printf("%-8s\t", "Name");
		System.out.printf("%-8s\t", "Location");
		System.out.printf("%-8s\t", "No of Seats");
		System.out.printf("%-8s\t", "Email");
		System.out.printf("%-8s\t", "IsApproved");
		System.out.println();
		for(GymCenter gymCenter: gyms) {
			System.out.printf("%-8s\t", gymCenter.getId());
			System.out.printf("%-8s\t", gymCenter.getName());
			System.out.printf("%-8s\t", gymCenter.getLocation());
			System.out.printf("%-8s\t", gymCenter.getNoOfSeats());
			System.out.printf("%-8s\t", gymCenter.getGymOwnerEmail());
			
			if(gymCenter.isApproved())
			{
				System.out.printf("%-8s\t", ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.printf("%-8s\t", "Yes");
			}
			else
			{
				System.out.printf("%-8s\t", ANSI_RED + "No" + ANSI_RESET);
//				System.out.println(ANSI_RED + "No" + ANSI_RESET);
//				System.out.printf("%-8s\t", "No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewAllGymOwners() {
		List<GymOwner> owners = adminBusiness.viewAllApprovedGymOnwers();
		System.out.printf("%-8s\t", "Id");
		System.out.printf("%-8s\t", "Address");
		System.out.printf("%-8s\t", "Email");
		System.out.printf("%-8s\t", "GST Number");
		System.out.printf("%-8s\t", "Name");
		System.out.printf("%-8s\t", "Phone");
		System.out.printf("%-8s\t", "IsApproved");
		System.out.println();
		for(GymOwner gymOwner: owners) {
			System.out.printf("%-8s\t", gymOwner.getId());
			System.out.printf("%-8s\t", gymOwner.getAddress());
			System.out.printf("%-8s\t", gymOwner.getEmail());
			System.out.printf("%-8s\t", gymOwner.getGstNumber());
			System.out.printf("%-8s\t", gymOwner.getName());
			System.out.printf("%-8s\t", gymOwner.getPhone());
			if(gymOwner.isApproved())
			{
				System.out.printf("%-8s\t", ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.printf("%-8s\t", "Yes");
			}
			else
			{
				System.out.printf("%-8s\t", ANSI_RED + "No" + ANSI_RESET);
//				System.out.println(ANSI_RED + "No" + ANSI_RESET);
//				System.out.printf("%-8s\t", "No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void adminPage(Scanner sc){
		while(true) {
			System.out.println("1. View All Gym Owners");
			System.out.println("2. View All Gyms");
			System.out.println("3. View Pending Gym Owner Requests");
			System.out.println("4. View Pending Gym Requests");
			System.out.println("5. Approve Gym Request");
			System.out.println("6. Approve Gym Owner Request");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				viewAllGymOwners();
				break;
			case 2:
				viewAllGymCenters();
				break;
			case 3:
				viewPendingGymOwnerRequests();
				break;
			case 4:
				viewPendingGymRequests();
				break;
			case 5:
				approveGymRequest(sc);
				break;
			case 6:
				approveGymOwnerRequest(sc);
				break;
			case 7:
				GMSApplicationClient.mainPage();
				break;

			default:
				System.out.println("Wrong choice");
			}
		}
	}
	

}
