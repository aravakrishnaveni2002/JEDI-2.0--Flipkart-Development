/**
 * 
 */
package com.flipkart.DAO;

import java.sql.*;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.*;


/**
 * 
 */
public class CustomerDaoImpl implements CustomerDao {
	Connection connection = null;
	PreparedStatement statement = null;
	public Customer getCustomerDetails(String customerEmail) {
		
		Customer customer = new Customer();

		try {
			connection = DBUtils.getConnection();
			System.out.println("Fetching Customer deatils...");
			statement = connection.prepareStatement(SQLQueries.FETCH_CUSTOMER_DETAILS);
		    statement.setString(1,customerEmail);
		    
		    ResultSet rs = statement.executeQuery();
		    while(rs.next()){
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getInt("phone"));
			}

		    
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return customer;
	}
	
	public List<GymCenter> viewAllGymCentres() {
		List<GymCenter> allGymCenters = new ArrayList<>();
		
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
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_ALL_BOOKEDSLOTS);
			statement.setString(1,customerEmail);
			statement.setInt(2,1);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	BookedSlot bookedSlot = new BookedSlot();
		    	bookedSlot.setId(rs.getInt("id"));
		    	bookedSlot.setGymCenterId(rs.getInt("gymCenterId"));
		    	bookedSlot.setSlotId(rs.getInt("slotId"));
		    	bookedSlot.setCustomerEmail(rs.getString("customerEmail"));
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
		int rs = 0;
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_BOOKEDSLOT);
			statement.setInt(1,gymCenterId);
			statement.setInt(2,slotId);
			statement.setString(3,customerEmail);
			statement.setString(4,date);
			statement.setInt(5,1);
			rs = statement.executeUpdate();
			statement.close();

		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
		if(rs == 1) return true;
		return false;
	}
	
	public BookedSlot isAlreadyBooked(int slotId,String customerEmail,String date) {
		BookedSlot bookedSlot = new BookedSlot();
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.CHECK_SLOT_ALREADY_BOOKED);
			statement.setInt(1, slotId);
			statement.setString(2, customerEmail);
			statement.setString(3, date);
		    ResultSet output = statement.executeQuery();
		    if(output.next()){
				BookedSlot bookedslot = new BookedSlot();
				bookedslot.setId(output.getInt("id"));
				bookedslot.setSlotId(output.getInt("slotId"));
				bookedslot.setCustomerEmail(output.getString("customerEmail"));
				bookedslot.setGymCenterId(output.getInt("gymCenterId"));
				bookedslot.setDate(output.getString("date"));
				return bookedslot;
			}

		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
		
		return null;
	}
	
	public boolean cancelSlot(int bookingId,String customerEmail) {
		int rs = 0;
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.CANCEL_BOOKING);
			statement.setInt(1, 0);
			statement.setInt(2, bookingId);
			statement.setString(3, customerEmail);

			rs = statement.executeUpdate();
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
		if(rs == 0) return false;
		return true;
	}
}
