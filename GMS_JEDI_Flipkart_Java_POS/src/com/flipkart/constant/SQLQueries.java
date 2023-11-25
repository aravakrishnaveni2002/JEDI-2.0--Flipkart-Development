/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public class SQLQueries {
	
	public static final String FETCH_ALL_APPROVED_GYMS = "SELECT * FROM GymCenter WHERE isApproved=1";
	public static final String FETCH_ALL_SLOTS_OF_GYM = "SELECT * FROM BookedSlot WHERE gymId=?";
	public static final String FETCH_GYMOWNER_DETAILS = "SELECT * FROM GymOwner WHERE id=?";
	public static final String FETCH_GYMOWNER_ALL_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=?";
	public static final String INSERT_GYM = "INSERT INTO GymCenter (id, gymOwnerEmail, name, location, noOfSeats, isApproved) values (?, ?, ?, ?, ?, ?)";
	public static final String INSERT_SLOT = "INSERT INTO AllSlots (gymCenterId, slotId) values(?, ?)";
	public static final String FETCH_GYMOWNER_ALL_APPROVED_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=? and isApproved=1";
	public static final String CHECK_GYMOWNER_APPROVEVAL = "SELECT * FROM GymOwner WHERE id=? and isApproved=1";
	public static final String FETCH_ALL_BOOKEDSLOTS = "SELECT * FROM BookedSlot WHERE customerId=?";
	public static final String CHECK_SLOT_ALREADY_BOOKED = "SELECT * FROM BookedSlot WHERE slotId=? and gymCenterId=? and customerEmail=? and date=?";
	public static final String CANCEL_BOOKING = "Delete from BookedSlot where id = ? and customerEmail = ?";
}
