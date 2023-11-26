/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public class SQLQueries {
	
	public static final String FETCH_ALL_APPROVED_GYMS = "SELECT * FROM GymCenter WHERE isApproved=1";
	public static final String FETCH_ALL_SLOTS_OF_GYM = "SELECT * FROM AllSlots WHERE gymCenterId=?";
	public static final String FETCH_GYMOWNER_DETAILS = "SELECT * FROM GymOwner WHERE id=?";
	public static final String FETCH_GYMOWNER_ALL_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=?";
	public static final String INSERT_GYM = "INSERT INTO GymCenter (gymOwnerEmail, name, location, noOfSeats, isApproved) values (?, ?, ?, ?, ?)";
	public static final String INSERT_SLOT = "INSERT INTO AllSlots (gymCenterId, slotId) values(?, ?)";

	public static final String INSERT_BOOKEDSLOT = "INSERT INTO BookedSlot (gymCenterId, slotId, customerEmail, date) values(?, ?, ?, ?)";
	public static final String FETCH_GYMOWNER_ALL_APPROVED_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=? and isApproved=1";
	public static final String CHECK_GYMOWNER_APPROVEVAL = "SELECT * FROM GymOwner WHERE id=? and isApproved=1";
	public static final String FETCH_ALL_BOOKEDSLOTS = "SELECT * FROM BookedSlot WHERE customerId=?";
	public static final String CHECK_SLOT_ALREADY_BOOKED = "SELECT * FROM BookedSlot WHERE slotId=? and customerEmail=? and date=?";
	public static final String CANCEL_BOOKING = "Delete from BookedSlot where id = ? and customerEmail = ?";
	public static final String FETCH_PENDING_GYM_CENTERS = "SELECT * FROM GymCenter WHERE isApproved = 0";
	public static final String FETCH_PENDING_OR_APPROVED_GYM_OWNERS = "SELECT * FROM GymOwner WHERE isApproved = ?";
	public static final String APPROVE_GYM_OWNER = "UPDATE GymOwner SET isApproved = true WHERE id = ?";
	public static final String APPROVE_GYM_CENTER = "UPDATE GymCenter SET isApproved = true WHERE id = ?";
	public static final String REGISTERING_NEW_CUSTOMER = "INSERT INTO Customer (name,address,email,phone) VALUES (?, ?, ?, ?)";
	public static final String REGISTERING_NEW_GYMOWNER = "INSERT INTO GymOwner (name,address,email,phone,gstNumber,isApproved) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String REGISTERING_NEW_USER = "INSERT INTO User (email,password,roleId) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String FETCH_ALL_CUSTOMERS_USERS = "SELECT * FROM User WHERE roleId = ?";
}
