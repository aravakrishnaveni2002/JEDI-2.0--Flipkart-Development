package com.flipkart.bean;

public class AddSlotRequest {

    private int slotId;
    private int gymCenterId;
    private String time;


    public int getSlotId() {
        return this.slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(int gymCenterId) {
        this.gymCenterId = gymCenterId;
    }
}
