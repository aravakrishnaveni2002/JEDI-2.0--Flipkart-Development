package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    Connection connection = null;
    PreparedStatement statement = null;
    public void registerCustomer(Customer customer){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMSFlipFit", "root", "");
            System.out.println("Registering new customer...");
            statement = connection.prepareStatement(SQLQueries.REGISTERING_NEW_CUSTOMER);
            statement.setString(1, customer.getName());
            statement.setString(2,customer.getAddress());
            statement.setString(3,customer.getEmail());
            statement.setString(4,Long.toString(customer.getPhone()));
            statement.executeUpdate();
            statement.close();

        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
    }

    public void registerGymOwner(GymOwner gymOwner){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMSFlipFit", "root", "");
            System.out.println("Registering new Gym Owner...");
            statement = connection.prepareStatement(SQLQueries.REGISTERING_NEW_GYMOWNER);
            statement.setString(1, gymOwner.getName());
            statement.setString(2,gymOwner.getAddress());
            statement.setString(3,gymOwner.getEmail());
            statement.setString(4,Long.toString(gymOwner.getPhone()));
            statement.setString(5, gymOwner.getGstNumber());
            statement.setString(6, Boolean.toString(gymOwner.isApproved()));
            statement.executeUpdate();
            statement.close();

        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
    }

    public void registerUser(User user){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMSFlipFit", "root", "");
            System.out.println("Registering new User...");
            statement = connection.prepareStatement(SQLQueries.REGISTERING_NEW_USER);
            statement.setString(1, user.getEmail());
            statement.setString(2,user.getPassword());
            statement.setString(3,Integer.toString(user.getRoleId()));
            statement.executeUpdate();
            statement.close();

        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
    }

    public List<User> viewAllCustomers(){
        List<User> customerList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMSFlipFit", "root", "");
            System.out.println("Listing all customers...");
            statement = connection.prepareStatement(SQLQueries.FETCH_ALL_CUSTOMERS_USERS);
            statement.setString(1,Integer.toString(3));
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setRoleId(rs.getInt("roleId"));
                user.setPassword(rs.getString("passowrd"));
                user.setEmail(rs.getString("email"));
                customerList.add(user);
            }
        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return customerList;
    }

    public List<User> viewAllGymOwners(){
        List<User> gymOwnerList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMSFlipFit", "root", "");
            System.out.println("Listing all Gym Owners...");
            statement = connection.prepareStatement(SQLQueries.FETCH_ALL_CUSTOMERS_USERS);
            statement.setString(1,Integer.toString(2));
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setRoleId(rs.getInt("roleId"));
                user.setPassword(rs.getString("passowrd"));
                user.setEmail(rs.getString("email"));
                gymOwnerList.add(user);
            }
        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return gymOwnerList;
    }

    public User getAdmin(){
        User user = new User();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMSFlipFit", "root", "");
            System.out.println("Listing all Gym Owners...");
            statement = connection.prepareStatement(SQLQueries.FETCH_ALL_CUSTOMERS_USERS);
            statement.setString(1,Integer.toString(1));
            ResultSet rs = statement.executeQuery();
            user.setRoleId(rs.getInt("roleId"));
            user.setPassword(rs.getString("passowrd"));
            user.setEmail(rs.getString("email"));

        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return user;
    }
}
