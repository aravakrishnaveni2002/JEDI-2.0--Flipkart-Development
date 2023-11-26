package com.flipkart.business;

import com.flipkart.bean.BookedSlot;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.List;

public interface CustomerBusinessInterface {

    /**
     * Fetches the details of a customer based on the customer ID.
     * @param customerEmail The Email of the customer
     * @return Customer object representing the customer details
     */
    public Customer getCustomerDetails(String customerEmail);

    /**
     * Fetches the list of available gyms.
     * @return List of Gymnasium objects representing the available gyms
     */
    public List<GymCenter> viewAllGymCentres();

    /**
     * Books slots for a customer at a specified gym, date, and slot time.
     * @param gymCenterId The ID of the gym
     * @param slotId The ID of the slot
     * @param customerEmail The Email of the customer
     * @param date The date of the slot
     */
    public void bookSlot(int gymCenterId,int slotId,String date,String customerEmail);

    /**
     * Checks if a customer has already booked a slot at a specified slot time and date.
     * @param slotId The ID of the slot
     * @param customerEmail The email of the customer
     * @param date The date of the slot
     * @return Booked slot object representing the booked slot details
     */
    public BookedSlot isAlreadyBooked(int slotId, String customerEmail, String date);

    /**
     * Cancels a booked slot for a customer based on the booking ID.
     * @param customerEmail The email of the customer
     * @param bookingId The ID of the booking to cancel
     */
    public void cancelSlot(int bookingId,String customerEmail);

    /**
     * Fetches the booked slots for a customer based on the customer's email.
     * @param customerEmail The email of the customer
     */
    public List<BookedSlot> viewAllBookings(String customerEmail);

}
