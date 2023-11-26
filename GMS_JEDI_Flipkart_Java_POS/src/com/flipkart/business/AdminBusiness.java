/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.DAO.*;
import java.util.*;

/**
 * This class implements the AdminBusinessInterface and provides the functionality for admin operations in the Gym Management System.
 */
public class AdminBusiness implements AdminBusinessInterface{
	AdminDao adminImpl = new AdminDaoImpl();

	/**
	 * Retrieves a list of pending gym requests.
	 * @return List of Gym objects
	 */
	public List<GymCenter> viewPendingGymRequests() {
		System.out.println("All pending Gym requests");
		return adminImpl.viewPendingGymRequests();
	}

	/**
	 * Retrieves a list of pending gym owner requests.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> viewPendingGymOwnerRequests() {
		System.out.println("All pending GymOwner requests");
		return adminImpl.viewPendingGymOwnerRequests();
	}

	/**
	 * Approves a single gym owner request.
	 * @param gymOwnerId The ID of the gymOwner to be approved
	 */
    public boolean approveGymOwnerRegistration(int gymOwnerId){

        System.out.println("GymOwner Approved Successfully");
        return adminImpl.approveGymOwnerRegistration(gymOwnerId);
    }

	/**
	 * Approves a single gym request.
	 * @param gymCenterId The ID of the gym request to be approved
	 */
    public boolean approveGymRegistration(int gymCenterId){
        System.out.println("Gym Approved Successfully");
        return adminImpl.approveGymRegistration(gymCenterId);
    }
	/**
	 * Retrieves a list of all gym owners in the system.
	 * @return List of GymOwner objects
	 */
    public List<GymOwner> viewAllApprovedGymOnwers() {
    	System.out.println("All GymOwners");
		return adminImpl.viewAllApprovedGymOnwers();
    }

	/**
	 * Retrieves a list of all gym in the system.
	 * @return List of Gym objects
	 */
    public List<GymCenter> viewAllApprovedGyms() {
    	System.out.println("All Gyms");
		return adminImpl.viewAllApprovedGyms();
    }
}
