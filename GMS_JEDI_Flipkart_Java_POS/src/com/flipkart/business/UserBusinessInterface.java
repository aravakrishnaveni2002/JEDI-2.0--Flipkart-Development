package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

public interface UserBusinessInterface {

    /**

     Registers a customer in the database.
     @param customer The Customer object representing the customer data
     */
    public void registerCustomer(Customer customer);

    /**
     * View all the customers which are in the list of users
     * @return List of all the customers
     */
    public List<User> viewAllCustomers();

    /**
     * View all the Gym Owners which are in the list of users
     * @return List of all the Gym Owners
     */
    public List<User> viewAllGymOwners();

    /**
     Registers a GymOwner in the database.
     @param gymOwner The gymOwner object representing the gym owner data
     */
    public void registerGymOwner(GymOwner gymOwner);

    public void registerUser(User user);

}
