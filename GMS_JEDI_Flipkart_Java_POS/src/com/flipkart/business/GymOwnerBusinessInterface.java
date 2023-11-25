package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.List;

public interface GymOwnerBusinessInterface {

    public GymOwner getGymOwnerDetails(String gymOwnerEmail);

    public List<Slot> viewAllSlots(int gymCenterId);

    public boolean isApproved(String gymOwnerEmail);

    public void addSlots(int gymCenterId,Slot slot);

    public void addGym(GymCenter gymCenter);

    public List<GymCenter> viewAllGymCenters(String gymOwnerEmail);
    
    public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail);

}
