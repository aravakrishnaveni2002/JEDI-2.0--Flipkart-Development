package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminBusinessInterface {

    public List<GymCenter> viewPendingGymRequests();

    public List<GymOwner> viewPendingGymOwnerRequests();

    public boolean approveGymOwnerRegistration(int gymOwnerId);

    public boolean approveGymRegistration(int gymCenterId);

    public List<GymOwner> viewAllApprovedGymOnwers();

    public List<GymCenter> viewAllApprovedGyms();

}
