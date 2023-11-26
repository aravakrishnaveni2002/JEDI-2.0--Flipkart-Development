/**
 * 
 */
package com.flipkart.client;
import java.util.Scanner;

import com.flipkart.business.*;
import com.flipkart.bean.*;
import java.util.*;

/**
 * 
 */
public class GMSGymOwnerClient {
	
	GymOwner gymOwner = new GymOwner();
	GymCenter gymCenter = new GymCenter();
	User user = new User();

	GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
	UserBusinessInterface userBusiness = new UserBusiness();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	public void registerGymOwner(Scanner sc){
		
		System.out.println("Enter your email: ");
		gymOwner.setEmail(sc.next());
	
		System.out.println("Enter your name: ");
		gymOwner.setName(sc.next());
		
		System.out.println("Enter your mobile: ");
		gymOwner.setPhone(sc.nextLong());
		
		System.out.println("Enter your address: ");
		gymOwner.setAddress(sc.next());
		
		System.out.println("Enter your GST number: ");
		gymOwner.setGstNumber(sc.next());
		
		System.out.println("Enter your password: ");
		String password = sc.next();
		
		
		user.setEmail(gymOwner.getEmail());
		user.setPassword(password);
		user.setRoleId(2);
		userBusiness.registerGymOwner(gymOwner);
	}
	
	public void registerGym(Scanner sc) {
		GymCenter gymCenter = new GymCenter();
		System.out.println("Add gym Details: ");
		System.out.print("Add GymCenter id: ");
		gymCenter.setId(sc.nextInt());
		System.out.print("Enter gym location: ");
		gymCenter.setLocation(sc.next());
		System.out.println("Enter the number of seats: ");
		gymCenter.setNoOfSeats(sc.nextInt());
		gymCenter.setGymOwnerEmail(gymOwner.getEmail());
		
		gymOwnerBusiness.addGym(gymCenter);
	}
	
	public void getGymOwnerDetails(String gymOwnerEmail) {
		GymOwner gymOwner = gymOwnerBusiness.getGymOwnerDetails(gymOwnerEmail);
		System.out.printf("%-8s\t", gymOwner.getId());
		System.out.printf("%-8s\t", gymOwner.getName());
		System.out.printf("%-8s\t", gymOwner.getEmail());
		System.out.printf("%-8s\t", gymOwner.getAddress());
		System.out.printf("%-8s\t", gymOwner.getGstNumber());
		System.out.printf("%-8s\t", gymOwner.getPhone());
		if(gymOwner.isApproved())
		{
			System.out.printf("%-8s\t");
			System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//			System.out.printf("%-8s\t", "Yes");
		}
		else
		{
			System.out.printf("%-8s\t");
			System.out.println(ANSI_RED + "No" + ANSI_RESET);
//			System.out.printf("%-8s\t", "No");
		}
		System.out.println("");
		
	}
	
	public void getAllGymDetails() {
		List<GymCenter> allGyms = gymOwnerBusiness.viewAllGymCenters(gymOwner.getEmail());
		for(GymCenter gym : allGyms) {
			System.out.printf("%-8s\t", gym.getId());
			System.out.printf("%-8s\t", gym.getLocation());
			System.out.printf("%-8s\t", gym.getNoOfSeats());
			
			if(gym.isApproved())
			{
				System.out.printf("%-8s\t");
				System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.printf("%-8s\t", "Yes");
			}
			else
			{
				System.out.printf("%-8s\t");
				System.out.println(ANSI_RED + "No" + ANSI_RESET);
//				System.out.printf("%-8s\t", "No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void getAllApprovedGymDetails() {
		List<GymCenter> allApprovedGyms = gymOwnerBusiness.viewAllApprovedGymCenters(gymOwner.getEmail());
		for(GymCenter gym : allApprovedGyms) {
			System.out.printf("%-8s\t", gym.getId());
			System.out.printf("%-8s\t", gym.getLocation());
			System.out.printf("%-8s\t", gym.getNoOfSeats());
			System.out.printf("%-8s\t", "Yes");
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void addSlots(Scanner sc, String gymOwnerEmail) {
		getAllGymDetails();
		System.out.println("Enter the gymCenter id for which you want to add slots: ");
		gymCenter.setId(sc.nextInt());
		if(!gymCenter.isApproved()){
			System.out.println(ANSI_RED + "This Gym is not Authorized" + ANSI_RESET);
//			System.out.println("This Gym is not Authorized");
			gymOwnerPage(sc, gymOwnerEmail);
		}
		else {
			viewAllSlots(gymCenter.getId());
			System.out.println("Add slot timing: ");
			Slot slot = new Slot();
			slot.setTime(sc.next());
			gymOwnerBusiness.addSlots(gymCenter.getId(),slot);
			gymOwnerPage(sc, gymOwnerEmail);
		}
	}
	
	public void viewAllSlots(int gymCenterId) {
		System.out.println("Listing all existing slots: ");
		List<Slot> allSlots = gymOwnerBusiness.viewAllSlots(gymCenter.getId());
		for(Slot slot : allSlots) {
			System.out.printf("%-8s\t", slot.getId());
			System.out.printf("%-8s\t", slot.getTime());
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewAllSlots(Scanner sc) {
		getAllApprovedGymDetails();
		System.out.println("Enter the gymCenter id for which you want to see all slots: ");
		viewAllSlots(sc.nextInt());
	}
	
	public void gymOwnerPage(Scanner sc,String gymOwnerEmail) {
		if(!gymOwnerBusiness.isApproved(gymOwnerEmail)) {
			System.out.println(ANSI_RED + "You are not a Authorized Gym Owner" + ANSI_RESET);
//			System.out.println("You are not a Authorized Gym Owner");
			GMSApplicationClient.mainPage();
		}
		else {
			gymOwner.setEmail(gymOwnerEmail);
			while(true) {
				System.out.println("1. Add Gyms");
				System.out.println("2. View All Gyms");
				System.out.println("3. Add Slots in a Gym");
				System.out.println("4. View All Slots of a Gym");
				System.out.println("5. View Own Details");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					registerGym(sc);
					break;
				case 2:
					getAllGymDetails();
					break;
				case 3:
					addSlots(sc, gymOwnerEmail);
					break;
				case 4:
					viewAllSlots(sc);
					break;
				case 5:
					getGymOwnerDetails(gymOwnerEmail);
				case 6:
					GMSApplicationClient.mainPage();
					break;
				default:
					System.out.println(ANSI_RED + "Incorrect Choice" + ANSI_RESET);
//					System.out.println("incorrect choice");
				}
			}
			
		}
	}
	

}
