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
	
	public Customer getCustomerDetails(String customerEmail) {
		
		Customer customer = new Customer();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
//			connection = DBUtils.getConnection();
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			System.out.println("Fetching Cutomer deatils...");
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_DETAILS);		    
		    statement.setString(1,customerEmail);
		    
		    ResultSet rs = statement.executeQuery();
		    
		    customer.setId(rs.getInt("id"));
		    customer.setEmail(rs.getString("email"));
		    customer.setAddress(rs.getString("address"));
		    customer.setName(rs.getString("name"));
		    customer.setPhone(rs.getInt("phone"));
		    
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
	
	public void bookSlot(int gymCenterId,int slotId,String date,String customerEmail) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_BOOKEDSLOT);

			statement.setString(1,customerEmail);
			statement.setInt(2,gymCenterId);
			statement.setInt(3,slotId);
			statement.setString(4,date);
			statement.executeUpdate();
			statement.close();

		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
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
