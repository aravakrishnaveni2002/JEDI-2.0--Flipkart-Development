/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class AdminBusiness {
	
	public static void viewPendingGymRequests() {
		System.out.println("All pending Gym requests");
	}
	
	public static void viewPendingGymOwnerRequests() {
		System.out.println("All pending GymOwner requests");
	}
	
    public static boolean approveGymOwnerRegistration(){
        System.out.println("GymOwner Approved Successfully");
        return true;
    }
    
    public static boolean approveGymRegistration(){
        System.out.println("Gym Approved Successfully");
        return true;
    }
    
    public static void viewAllGymOnwers() {
    	System.out.println("All GymOwners");
    }
    
    public static void viewAllGyms() {
    	System.out.println("All Gyms");
    }
}
