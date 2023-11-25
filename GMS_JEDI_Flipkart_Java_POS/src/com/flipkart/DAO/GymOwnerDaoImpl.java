/**
 * 
 */
package com.flipkart.DAO;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class GymOwnerDaoImpl implements GymOwnerDao {
	
	public GymOwner getGymOwnerDetails(String gymOwnerEmail) {
		GymOwner gymOwner = new GymOwner();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			System.out.println("Fetching GymOnwer Details...");
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_DETAILS);		    
		    statement.setString(1,gymOwnerEmail);
		    
		    ResultSet rs = statement.executeQuery();
		    
		    gymOwner.setId(rs.getInt("id"));
		    gymOwner.setEmail(rs.getString("email"));
		    gymOwner.setAddress(rs.getString("address"));
		    gymOwner.setGstNumber(rs.getString("gstNumber"));
		    gymOwner.setName(rs.getString("name"));
		    gymOwner.setPhone(rs.getString("phone"));	
		    gymOwner.setApproved(rs.getBoolean("isApproved"));
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return gymOwner;
	}
	
	public List<GymCenter> viewAllGymCenters(String gymOwnerEmail){
		List<GymCenter> allGyms =  new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_ALL_GYMS);
			statement.setString(1,gymOwnerEmail);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	GymCenter gym = new GymCenter();
				gym.setId(rs.getInt("id"));
				gym.setName(rs.getString("name"));
				gym.setLocation(rs.getString("location"));
				gym.setNoOfSeats(rs.getInt("noOfSeats"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setApproved(rs.getInt("isApproved"));
				allGyms.add(gym);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return allGyms;
	}
	
	public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail){
		List<GymCenter> allApprovedGyms =  new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_ALL_APPROVED_GYMS);
			statement.setString(1,gymOwnerEmail);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	GymCenter gym = new GymCenter();
				gym.setId(rs.getInt("id"));
				gym.setName(rs.getString("name"));
				gym.setLocation(rs.getString("location"));
				gym.setNoOfSeats(rs.getInt("noOfSeats"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setApproved(rs.getInt("isApproved"));
				allApprovedGyms.add(gym);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return allApprovedGyms;
	}
	
	public List<Slot> viewAllSlots(int gymCenterId){
		List<Slot> allSlots = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_ALL_SLOTS_OF_GYM);
			statement.setInt(1,gymCenterId);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	Slot slot = new Slot();
		    	slot.setId(rs.getInt("id"));
		    	slot.setTime(rs.getString("time"));
		    	allSlots.add(slot);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return allSlots;
	}
	
	public void addGym(GymCenter gymCenter) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_GYM);
			
			statement.setInt(1,gymCenter.getId());
			statement.setString(2,gymCenter.getGymOwnerEmail());
			statement.setString(3,gymCenter.getName());
			statement.setString(4,gymCenter.getLocation());
			statement.setInt(5,gymCenter.getNoOfSeats());
			statement.setInt(6,0);
			statement.executeUpdate();
			statement.close();
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public void addSlots(int gymCenterId,Slot slot) {
			
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_SLOT);
			
			statement.setInt(1,gymCenterId);
			statement.setInt(2,slot.getId());
			statement.executeUpdate();
			statement.close();
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }	
	}
	
	public boolean isApproved(String gymOwnerEmail) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.CHECK_GYMOWNER_APPROVEVAL);
			statement.setString(1, gymOwnerEmail);
		    ResultSet output = statement.executeQuery();
		    if(output.next())
		    	return true;
		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
		return false;
	}
	
	
}
