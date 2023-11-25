package com.flipkart.business;

import com.flipkart.bean.Slot;

public interface SlotBookingInterface {

    public boolean isAvailable(Slot slot);

    public boolean isWaiting();

    public boolean bookSlot(Slot slot, String date,int userId);

    public boolean cancelSlot(Slot slot, String date,int userId);

}
