/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.AdminBusiness;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class GMSAdminClient {
		
	AdminBusiness adminBusiness = new AdminBusiness();
	
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
		for(GymCenter gymCenter: gyms) {
			System.out.printf("%-8s\t", gymCenter.getId());
			System.out.printf("%-8s\t", gymCenter.getName());
			System.out.printf("%-8s\t", gymCenter.getLocation());
			System.out.printf("%-8s\t", gymCenter.getNoOfSeats());
			System.out.printf("%-8s\t", gymCenter.getGymOwnerEmail());
			
			if(gymCenter.isApproved())
			{
				System.out.printf("%-8s\t", "Yes");
			}
			else
			{
				System.out.printf("%-8s\t", "No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewPendingGymOwnerRequests() {
		List<GymOwner> owners = adminBusiness.viewPendingGymOwnerRequests();
		for(GymOwner gymOwner: owners) {
			System.out.printf("%-8s\t", gymOwner.getId());
			System.out.printf("%-8s\t", gymOwner.getAddress());
			System.out.printf("%-8s\t", gymOwner.getEmail());
			System.out.printf("%-8s\t", gymOwner.getGstNumber());
			System.out.printf("%-8s\t", gymOwner.getName());
			System.out.printf("%-8s\t", gymOwner.getPhone());
			if(gymOwner.isApproved())
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewAllGymCenters() {
		List<GymCenter> gyms = adminBusiness.viewAllApprovedGyms();
		for(GymCenter gymCenter: gyms) {
			System.out.printf("%-8s\t", gymCenter.getId());
			System.out.printf("%-8s\t", gymCenter.getName());
			System.out.printf("%-8s\t", gymCenter.getLocation());
			System.out.printf("%-8s\t", gymCenter.getNoOfSeats());
			System.out.printf("%-8s\t", gymCenter.getGymOwnerEmail());
			
			if(gymCenter.isApproved())
			{
				System.out.printf("%-8s\t", "Yes");
			}
			else
			{
				System.out.printf("%-8s\t", "No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewAllGymOwners() {
		List<GymOwner> owners = adminBusiness.viewAllApprovedGymOnwers();
		for(GymOwner gymOwner: owners) {
			System.out.printf("%-8s\t", gymOwner.getId());
			System.out.printf("%-8s\t", gymOwner.getAddress());
			System.out.printf("%-8s\t", gymOwner.getEmail());
			System.out.printf("%-8s\t", gymOwner.getGstNumber());
			System.out.printf("%-8s\t", gymOwner.getName());
			System.out.printf("%-8s\t", gymOwner.getPhone());
			if(gymOwner.isApproved())
			{
				System.out.printf("%-8s\t", "Yes");
			}
			else
			{
				System.out.printf("%-8s\t", "No");
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
