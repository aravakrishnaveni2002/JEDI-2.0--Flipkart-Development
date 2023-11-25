/**
 * 
 */
package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.BookedSlot;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

/**
 * 
 */
public interface CustomerDao {
	
	public Customer getCustomerDetails(String customerEmail);
	
	public List<GymCenter> viewAllGymCentres();
	
	public List<BookedSlot> viewAllBookings(String email);
	
	public void bookSlot(int gymCenterId,int slotId,String date,String customerEmail);
	
	public BookedSlot isAlreadyBooked(int gymCenterId,int slotId,String customerEmail,String date);
	
	public void cancelSlot(int bookingId,String customerEmail);
}
