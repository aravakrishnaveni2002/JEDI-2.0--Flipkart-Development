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

	GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();
	
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
		
		User user = new User();
		user.setEmail(gymOwner.getEmail());
		user.setPassword(password);
		user.setRoleId(2);
		
		UserBusiness userBusiness = new UserBusiness();
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
	
	public void getAllGymDetails() {
		List<GymCenter> allGyms = gymOwnerBusiness.viewAllGymCenters(gymOwner.getEmail());
		for(GymCenter gym : allGyms) {
			System.out.printf("%-8s\t", gym.getId());
			System.out.printf("%-8s\t", gym.getLocation());
			System.out.printf("%-8s\t", gym.getNoOfSeats());
			
			if(gym.isApproved())
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
	
	public void addSlots(Scanner sc, String gymOwnerEmail) {
		getAllGymDetails();
		System.out.println("Enter the gymCenter id for which you want to add slots: ");
		gymCenter.setId(sc.nextInt());
		if(!gymCenter.isApproved()){
			System.out.println("This Gym is not Authorized");
			gymOwnerPage(sc, gymOwnerEmail);
		}
		else {
			System.out.println("Add slot timing: ");
			Slot slot = new Slot();
			slot.setTime(sc.next());
			gymOwnerBusiness.addSlots(gymCenter.getId(),slot);
			gymOwnerPage(sc, gymOwnerEmail);
		}
	}
	
	public void gymOwnerPage(Scanner sc,String gymOwnerEmail) {
		if(!gymOwnerBusiness.isApproved(gymOwnerEmail)) {
			System.out.println("You are not a Authorized Gym Owner");
			GMSApplicationClient.mainPage();
		}
		else {
			gymOwner.setEmail(gymOwnerEmail);
			while(true) {
				System.out.println("1. Add Gyms");
				System.out.println("2. View Gyms");
				System.out.println("3. Add Slots");
				System.out.println("4. Exit");
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
				case 4:
					GMSApplicationClient.mainPage();
					break;
				default:
					System.out.println("incorrect choice");
				}
			}
			
		}
	}
	

}
