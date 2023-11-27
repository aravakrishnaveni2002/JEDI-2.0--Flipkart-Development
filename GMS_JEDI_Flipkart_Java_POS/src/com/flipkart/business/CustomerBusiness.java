/**
 *
 */
package com.flipkart.business;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.bean.BookedSlot;
import com.flipkart.DAO.*;
import com.flipkart.exception.NoDataFoundException;

import java.util.*;

/**
 *
 */
public class CustomerBusiness implements CustomerBusinessInterface {
	
	CustomerDao customerDao = new CustomerDaoImpl();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	/**
	 * Fetches the details of a customer based on the customer ID.
	 * @param customerEmail The email of the customer
	 * @return Customer object representing the customer details
	 */
	public Customer getCustomerDetails(String customerEmail) {
		return customerDao.getCustomerDetails(customerEmail);
	}

	/**
	 * Fetches the list of available gyms for the customer.
	 * @return List of Gymnasium objects representing the available gyms
	 */
	public List<GymCenter> viewAllGymCentres() {
		return customerDao.viewAllGymCentres();
	}

	/**
	 * Books slots for a customer at a specified gym, date, and slot time.
	 * @param gymCenterId The ID of the gym
	 * @param slotId The ID of the slot
	 * @param date The date of the slot
	 * @param customerEmail The email of the customer
	 */
	public boolean bookSlot(int gymCenterId,int slotId,String date,String customerEmail) throws NoDataFoundException{
		BookedSlot b = isAlreadyBooked(slotId,customerEmail,date);
		if(b != null) {
			try{
				cancelSlot(b.getId(),customerEmail);
			} catch (NoDataFoundException ne){
				ne.getMessage();
			}
		}

        if(customerDao.bookSlot(gymCenterId,slotId,date,customerEmail) == true) {
			System.out.println(ANSI_GREEN + "Slot Booked" + ANSI_RESET);
			return true;
		};
		throw new NoDataFoundException();
	}

	/**
	 * Checks if a customer has already booked a slot at a specified slot time and date.
	 * @param slotId The ID of the slot
	 * @param customerEmail The email of the customer
	 * @param date The date of the slot
	 * @return Booked slot object representing the booked slot details
	 */
	public BookedSlot isAlreadyBooked(int slotId,String customerEmail,String date) {
		return customerDao.isAlreadyBooked(slotId,customerEmail,date);
		
	}

	/**
	 * Cancels a booked slot for a customer based on the booking ID.
	 * @param customerEmail The email of the customer
	 * @param bookingId The ID of the booking to cancel
	 */
	public boolean cancelSlot(int bookingId,String customerEmail) throws NoDataFoundException{

		if(customerDao.cancelSlot(bookingId , customerEmail) == true) {
			System.out.println(ANSI_GREEN + "Slot Cancelled" + ANSI_RESET);
			return true;
		}
		throw new NoDataFoundException();

	}

	/**
	 * Fetches the booked slots for a customer based on the customer's email.
	 * @param customerEmail The email of the customer
	 */
	public List<BookedSlot> viewAllBookings(String customerEmail) {
		return customerDao.viewAllBookings(customerEmail);
	}

}
