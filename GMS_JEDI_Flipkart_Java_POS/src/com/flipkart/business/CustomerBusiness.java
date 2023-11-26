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
	public void bookSlot(int gymCenterId,int slotId,String date,String customerEmail) {
		BookedSlot b = isAlreadyBooked(slotId,customerEmail,date);
		if(b != null) {
			cancelSlot(b.getId(),customerEmail);
		}

        customerDao.bookSlot(gymCenterId,slotId,date,customerEmail);

		System.out.println("Slot booked");
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
	public void cancelSlot(int bookingId,String customerEmail) {
		System.out.println("Cancelling Slot");
		customerDao.cancelSlot(bookingId , customerEmail);
	}

	/**
	 * Fetches the booked slots for a customer based on the customer's email.
	 * @param customerEmail The email of the customer
	 */
	public List<BookedSlot> viewAllBookings(String customerEmail) {
		return customerDao.viewAllBookings(customerEmail);
	}

}
