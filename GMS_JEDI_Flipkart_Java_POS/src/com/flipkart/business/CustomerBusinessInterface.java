package com.flipkart.business;

import com.flipkart.bean.BookedSlot;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.List;

public interface CustomerBusinessInterface {

    public Customer getCustomerDetails(String customerEmail);

    public List<GymCenter> viewAllGymCentres();

    public void bookSlot(int gymCenterId,int slotId,String date,String customerEmail);

    public BookedSlot isAlreadyBooked(int gymCenterId, int slotId, String customerEmail, String date);

    public void cancelSlot(int bookingId,String customerEmail);

    public List<BookedSlot> viewAllBookings(String customerEmail);

}
