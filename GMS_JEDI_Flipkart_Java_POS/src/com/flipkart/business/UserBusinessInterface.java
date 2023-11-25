package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

public interface UserBusinessInterface {

    public void registerCustomer(Customer customer);

    public List<User> viewAllCustomers();

    public List<User> viewAllGymOwners();

    public void registerGymOwner(GymOwner gymOwner);

    public void login(User user);

    public void logout(User user);

    public void registerUser();

}
