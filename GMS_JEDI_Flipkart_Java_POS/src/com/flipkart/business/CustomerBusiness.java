/**
 *
 */
package com.flipkart.business;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.bean.BookedSlot;
import com.flipkart.DAO.*;
import java.util.*;

/**
 *
 */
public class CustomerBusiness implements CustomerBusinessInterface {
	
	CustomerDao customerDao = new CustomerDaoImpl();

	public Customer getCustomerDetails(String customerEmail) {
		return customerDao.getCustomerDetails(customerEmail);
	}

	public List<GymCenter> viewAllGymCentres() {
		return customerDao.viewAllGymCentres();
	}

	public boolean bookSlot(int gymCenterId,int slotId,String date,String customerEmail) {
		BookedSlot b = isAlreadyBooked(gymCenterId, slotId,customerEmail,date);
		if(b != null) {
			cancelSlot(b.getId(),customerEmail);
		}
		
		System.out.println("Slot booked");
		return true;
	}


	public BookedSlot isAlreadyBooked(int gymCenterId, int slotId,String customerEmail,String date) {
		return customerDao.isAlreadyBooked(gymCenterId,slotId,customerEmail,date);
		
	}

	public void cancelSlot(int bookingId,String customerEmail) {
		System.out.println("Cancelling Slot");
		customerDao.cancelSlot(bookingId , customerEmail);
	}

	public List<BookedSlot> viewAllBookings(String customerEmail) {
		return customerDao.viewAllBookings(customerEmail);
	}

}
