/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.*;
import java.util.*;

/**
 * 
 */
public class AdminBusiness {
	
	public List<GymCenter> viewPendingGymRequests() {
		System.out.println("All pending Gym requests");
		return new ArrayList<GymCenter>();
	}
	
	public List<GymOwner> viewPendingGymOwnerRequests() {
		System.out.println("All pending GymOwner requests");
		return new ArrayList<GymOwner>();
	}
	
    public boolean approveGymOwnerRegistration(int gymOwnerId){
        System.out.println("GymOwner Approved Successfully");
        return true;
    }
    
    public boolean approveGymRegistration(int gymCenterId){
        System.out.println("Gym Approved Successfully");
        return true;
    }
    
    public List<GymOwner> viewAllGymOnwers() {
    	System.out.println("All GymOwners");
    	return new ArrayList<GymOwner>();
    }
    
    public List<GymCenter> viewAllGyms() {
    	System.out.println("All Gyms");
    	return new ArrayList<GymCenter>();
    }
}
