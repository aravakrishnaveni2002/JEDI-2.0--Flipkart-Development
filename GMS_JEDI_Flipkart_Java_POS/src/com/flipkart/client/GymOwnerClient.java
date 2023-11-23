/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.GymOwnerBusiness;

/**
 * 
 */
public class GymOwnerClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();
		gymOwnerBusiness.isApproved();
		gymOwnerBusiness.registerOwner();
		gymOwnerBusiness.addGymDetails();
		
	}

}
