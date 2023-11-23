/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.Customer;
/**
 * 
 */
public class CustomerBusiness {

    public static Customer register(){
        System.out.println("User Created Successfully");
        return new Customer();
    }
    public static boolean login(){
        System.out.println("Logged In");
        return true;
    }
    public static void viewCentres(){
        System.out.println("Listing All Centres");
        return;
    }
    public static boolean cancelSlot(){
        System.out.println("Cancelling Slot");
        return true;
    }

    public static void viewBookings(){
        System.out.println("Listing all Bookings");
        return;
    }

}
