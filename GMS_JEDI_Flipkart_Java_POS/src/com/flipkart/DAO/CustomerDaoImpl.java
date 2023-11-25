/**
 * 
 */
package com.flipkart.DAO;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLQueries;


/**
 * 
 */
public class CustomerDaoImpl implements CustomerDao {
	
	public Customer getCustomerDetails(String customerEmail) {
		
		Customer customer = new Customer();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			System.out.println("Fetching Cutomer deatils...");
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_DETAILS);		    
		    statement.setString(1,customerEmail);
		    
		    ResultSet rs = statement.executeQuery();
		    
		    customer.setId(rs.getInt("id"));
		    customer.setEmail(rs.getString("email"));
		    customer.setAddress(rs.getString("address"));
		    customer.setName(rs.getString("name"));
		    customer.setPhone(rs.getString("phone"));	
		    
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return customer;
	}
	
	public List<GymCenter> viewAllGymCentres() {
		List<GymCenter> allGymCenters = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_ALL_APPROVED_GYMS);
	
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	GymCenter gym = new GymCenter();
				gym.setId(rs.getInt("id"));
				gym.setName(rs.getString("name"));
				gym.setLocation(rs.getString("location"));
				gym.setNoOfSeats(rs.getInt("noOfSeats"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				allGymCenters.add(gym);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return allGymCenters;
	}
	
	public List<BookedSlot> viewAllBookings(String customerEmail) {
		List<BookedSlot> allBookings = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_ALL_BOOKEDSLOTS);
			statement.setString(1,customerEmail);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	BookedSlot bookedSlot = new BookedSlot();
		    	bookedSlot.setId(rs.getInt("id"));
		    	bookedSlot.setGymCenterIde(rs.getInt("gymCenterId"));
		    	bookedSlot.setSlotId(rs.getInt("slotId"));
		    	bookedSlot.setCustomerId(rs.getInt("customerId"));
		    	bookedSlot.setDate(rs.getString("date"));
		    	allBookings.add(bookedSlot);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return allBookings;
	}
	
	public boolean bookSlot(int gymCenterId,int slotId,String date,String customerEmail) {
		return false;
	}
	
	public BookedSlot isAlreadyBooked(int gymCenterId,int slotId,String customerEmail,String date) {
		BookedSlot bookedSlot = new BookedSlot();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.CHECK_SLOT_ALREADY_BOOKED);
			statement.setInt(1, slotId);
			statement.setInt(2, gymCenterId);
			statement.setString(3, customerEmail);
			statement.setString(4, date);
		    ResultSet output = statement.executeQuery();
		    if(output.next())
		    	return true;
		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
		
		return null;
	}
	
	public void cancelSlot(int bookingId,String customerEmail) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.CANCEL_BOOKING);
			statement.setInt(1, bookingId);
			statement.setString(2, customerEmail);
			statement.executeUpdate();
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
	}
}
