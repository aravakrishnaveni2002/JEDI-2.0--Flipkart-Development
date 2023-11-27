package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.List;
import com.flipkart.exception.DataEntryException;
import com.flipkart.exception.GymDetailsNotFoundException;
import com.flipkart.exception.NoDataFoundException;
import com.flipkart.exception.GymNotFoundException;

public interface GymOwnerBusinessInterface {

    /**

     This method fetches the details of a gym owner based on the gym owner ID.
     @param gymOwnerEmail The Email of the gym owner
     @return The GymOwner object representing the gym owner details
     */
    public GymOwner getGymOwnerDetails(String gymOwnerEmail);

    /**

     This method fetches all the possible slots that a gym owner can select from.
     @return The list of Slots objects representing the possible slots
     */
    public List<Slot> viewAllSlots(int gymCenterId);

    /**

     This method checks if a gym owner is approved based on the email address.
     @param gymOwnerEmail The email address of the gym owner
     @return true if the gym owner is approved, false otherwise
     */
    public boolean isApproved(String gymOwnerEmail);

    /**

     This method checks if a gym center is approved based on the gym center id.
     @param gymCenterId The id of the gym center
     @return true if the gym center is approved, false otherwise
     */
    public boolean isApproved(int gymCenterId);

    /**
     This method allows a gym owner to add a particular slot for their gym.
     @param gymCenterId The ID of the gym
     @param slot The Details of the slot to be added
     */
    public void addSlots(int gymCenterId,Slot slot);

    /**

     This method allows a gym owner to add details of a particular gym.
     @param gymCenter The Gym object representing the gym details
     */
    public void addGym(GymCenter gymCenter) throws GymDetailsNotFoundException, DataEntryException;

    /**

     This method allows a gym owner to add details of a particular slot.
     @param slot The Slot object representing the gym details
     */
    public void createSlot(Slot slot);

    /**
     * This method fetches the gym details that belong to a gym owner.
     * @param gymOwnerEmail The Email of the gym owner
     * @return The list of GymCenter objects representing the gym details
     */

    public List<GymCenter> viewAllGymCenters(String gymOwnerEmail) throws GymNotFoundException, NoDataFoundException;

    /**
     * This method fetches the all approved gym details that belong to a gym owner.
     * @param gymOwnerEmail The Email of the gym owner
     * @return The list of GymCenter objects representing the gym details
     */
    public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail);

}
