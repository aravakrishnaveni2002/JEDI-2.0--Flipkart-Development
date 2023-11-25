/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.*;
import java.util.*;

/**
 * This class implements the AdminBusinessInterface and provides the functionality for admin operations in the Gym Management System.
 */
public class AdminBusiness implements AdminBusinessInterface{
	List<GymCenter> pendingGymRequests;
	List<GymCenter> allApprovedGyms;
	List<GymOwner> pendingGymOwnerRequests;
	List<GymOwner> allApprovedGymOwners;


	public AdminBusiness() {
		GymOwner go1 = new GymOwner();
		go1.setId(1);
		go1.setAddress("India");
		go1.setEmail("ravi@gmail.com");
		go1.setGstNumber("676fj");
		go1.setName("Ravi");
		go1.setPhone(2432523);
		go1.setApproved(true);
		
		GymOwner go2 = new GymOwner();
		go2.setId(2);
		go2.setAddress("India");
		go2.setEmail("raj@gmail.com");
		go2.setGstNumber("23898j");
		go2.setName("Raj");
		go2.setPhone(122344);
		go2.setApproved(true);
		
		GymOwner go3 = new GymOwner();
		go3.setId(3);
		go3.setAddress("India");
		go3.setEmail("ramesh@gmail.com");
		go3.setGstNumber("234gj");
		go3.setName("Ramesh");
		go3.setPhone(4566);
		go3.setApproved(false);
		
		GymCenter g1 = new GymCenter();
		g1.setId(1);
		g1.setName("CureFit");
		g1.setGymOwnerEmail("ravi@gmail.com");
		g1.setApproved(true);
		g1.setLocation("Kolkata");
		g1.setNoOfSeats(20);
		
		GymCenter g2 = new GymCenter();
		g2.setId(2);
		g2.setName("Fit");
		g2.setGymOwnerEmail("raj@gmail.com");
		g2.setApproved(true);
		g2.setLocation("Ballandur");
		g2.setNoOfSeats(20);
		
		GymCenter g3 = new GymCenter();
		g3.setId(3);
		g3.setName("Gym");
		g3.setGymOwnerEmail("raj@gmail.com");
		g3.setApproved(false);
		g3.setLocation("Hyderabad");
		g3.setNoOfSeats(30);
		
		allApprovedGyms = new ArrayList<>();
		allApprovedGyms.add(g1);
		allApprovedGyms.add(g2);
		
		allApprovedGymOwners = new ArrayList<>();
		allApprovedGymOwners.add(go1);
		allApprovedGymOwners.add(go2);
		
		pendingGymRequests = new ArrayList<>();
		pendingGymRequests.add(g3);
		pendingGymOwnerRequests = new ArrayList<>();
		pendingGymOwnerRequests.add(go3);
		
	}

	/**
	 * Retrieves a list of pending gym requests.
	 * @return List of Gym objects
	 */
	public List<GymCenter> viewPendingGymRequests() {
		System.out.println("All pending Gym requests");
		return pendingGymRequests;
	}

	/**
	 * Retrieves a list of pending gym owner requests.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> viewPendingGymOwnerRequests() {
		System.out.println("All pending GymOwner requests");
		return pendingGymOwnerRequests;
	}

	/**
	 * Approves a single gym owner request.
	 * @param gymOwnerId The ID of the gymOwner to be approved
	 */
    public boolean approveGymOwnerRegistration(int gymOwnerId){
    	
    	for(int i=0;i<pendingGymOwnerRequests.size();i++) {
    		if(pendingGymOwnerRequests.get(i).getId() == gymOwnerId) {
    			pendingGymOwnerRequests.get(i).setApproved(true);
    			allApprovedGymOwners.add(pendingGymOwnerRequests.get(i));
    			pendingGymOwnerRequests.remove(pendingGymOwnerRequests.get(i));
    			break;
    		}
    	}
        System.out.println("GymOwner Approved Successfully");
        return true;
    }

	/**
	 * Approves a single gym request.
	 * @param gymCenterId The ID of the gym request to be approved
	 */
    public boolean approveGymRegistration(int gymCenterId){
    	
    	for(int i=0;i<pendingGymRequests.size();i++) {
    		if(pendingGymRequests.get(i).getId() == gymCenterId) {
    			pendingGymRequests.get(i).setApproved(true);
    			allApprovedGyms.add(pendingGymRequests.get(i));
    			pendingGymRequests.remove(pendingGymRequests.get(i));
    			break;
    		}
    	}

        System.out.println("Gym Approved Successfully");
        return true;
    }
	/**
	 * Retrieves a list of all gym owners in the system.
	 * @return List of GymOwner objects
	 */
    public List<GymOwner> viewAllApprovedGymOnwers() {
    	System.out.println("All GymOwners");
    	return allApprovedGymOwners;
    }

	/**
	 * Retrieves a list of all gym in the system.
	 * @return List of Gym objects
	 */
    public List<GymCenter> viewAllApprovedGyms() {
    	System.out.println("All Gyms");
    	return allApprovedGyms;
    }
}
