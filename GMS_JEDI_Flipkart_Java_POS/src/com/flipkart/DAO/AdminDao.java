/**
 * 
 */
package com.flipkart.DAO;
import com.flipkart.bean.*;
import java.util.*;

/**
 * 
 */
public interface AdminDao {
	
	public List<GymCenter> viewPendingGymRequests();
	
	public List<GymOwner> viewPendingGymOwnerRequests();
	
	public List<GymCenter> viewAllApprovedGyms();
	
	public List<GymOwner> viewAllApprovedGymOnwers();
	
	public boolean approveGymOwnerRegistration(int gymOwnerId);
	
	public boolean approveGymRegistration(int gymCenterId);
	
}
