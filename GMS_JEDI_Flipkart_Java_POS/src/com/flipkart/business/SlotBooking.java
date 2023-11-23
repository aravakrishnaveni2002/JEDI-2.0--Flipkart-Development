/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class SlotBooking {
    public static boolean isAvailable() {
        System.out.println("Slots are Available");
        return true;
    }

    public static boolean isWaiting() {
        System.out.println("Slots Booked, redirecting to Waiting list");
        return true;
    }

    public static boolean bookSlot() {
        System.out.println("Slot booked Successfully");
        return true;
    }
}
