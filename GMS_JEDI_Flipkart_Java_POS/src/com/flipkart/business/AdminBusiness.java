/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.DAO.*;
import com.flipkart.exception.GymDetailsNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

import java.util.*;

/**
 * This class implements the AdminBusinessInterface and provides the functionality for admin operations in the Gym Management System.
 */
public class AdminBusiness implements AdminBusinessInterface{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	AdminDao adminImpl = new AdminDaoImpl();

	/**
	 * Retrieves a list of pending gym requests.
	 * @return List of Gym objects
	 */
	public List<GymCenter> viewPendingGymRequests() {
		System.out.println("All pending Gym requests");
		System.out.println("-------------------------------------");
		return adminImpl.viewPendingGymRequests();
	}

	/**
	 * Retrieves a list of pending gym owner requests.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> viewPendingGymOwnerRequests() {
		System.out.println("All pending GymOwner requests");
		System.out.println("-------------------------------------");
		return adminImpl.viewPendingGymOwnerRequests();
	}

	/**
	 * Approves a single gym owner request.
	 * @param gymOwnerId The ID of the gymOwner to be approved
	 */
    public boolean approveGymOwnerRegistration(int gymOwnerId) throws GymOwnerNotFoundException {
		System.out.println("-------------------------------------");
        if(adminImpl.approveGymOwnerRegistration(gymOwnerId) == true) {
			System.out.println(ANSI_GREEN + "GymOwner Approved Successfully" + ANSI_RESET);
			return true;
		}
		throw new GymOwnerNotFoundException();
    }

	/**
	 * Approves a single gym request.
	 * @param gymCenterId The ID of the gym request to be approved
	 */
    public boolean approveGymRegistration(int gymCenterId) throws GymDetailsNotFoundException {

//        System.out.println("Gym Approved Successfully");
       if(adminImpl.approveGymRegistration(gymCenterId) == true){
		   System.out.println(ANSI_GREEN + "Gym Approved Successfully" + ANSI_RESET);
		   return true;
	   }
	   throw new GymDetailsNotFoundException();
    }
	/**
	 * Retrieves a list of all gym owners in the system.
	 * @return List of GymOwner objects
	 */
    public List<GymOwner> viewAllApprovedGymOnwers() {
    	System.out.println("All GymOwners");
		System.out.println("-------------------------------------");
		return adminImpl.viewAllApprovedGymOnwers();
    }

	/**
	 * Retrieves a list of all gym in the system.
	 * @return List of Gym objects
	 */
    public List<GymCenter> viewAllApprovedGyms() {
    	System.out.println("All Gyms");
		System.out.println("-------------------------------------");
		return adminImpl.viewAllApprovedGyms();
    }
}
