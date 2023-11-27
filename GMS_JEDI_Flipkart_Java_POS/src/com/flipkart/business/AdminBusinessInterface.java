package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.exception.GymDetailsNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

import java.util.List;

public interface AdminBusinessInterface {

    /**
     * Retrieves a list of pending gym requests.
     * @return List of Gymnasium objects
     */
    public List<GymCenter> viewPendingGymRequests();

    /**
     * Retrieves a list of pending gym owner requests.
     * @return List of GymOwner objects
     */
    public List<GymOwner> viewPendingGymOwnerRequests();

    /**
     * Approves a single gym owner request.
     * @param gymOwnerId The ID of the request to be approved
     */
    public boolean approveGymOwnerRegistration(int gymOwnerId) throws GymOwnerNotFoundException;

    /**
     * Approves a single gym request.
     * @param gymCenterId The ID of the gym request to be approved
     */
    public boolean approveGymRegistration(int gymCenterId) throws GymDetailsNotFoundException;

    /**
     * Retrieves a list of all gym owners in the system.
     * @return List of GymOwner objects
     */
    public List<GymOwner> viewAllApprovedGymOnwers();

    /**
     * Retrieves a list of all gyms in the system.
     * @return List of Gymnasium objects
     */
    public List<GymCenter> viewAllApprovedGyms();

}
