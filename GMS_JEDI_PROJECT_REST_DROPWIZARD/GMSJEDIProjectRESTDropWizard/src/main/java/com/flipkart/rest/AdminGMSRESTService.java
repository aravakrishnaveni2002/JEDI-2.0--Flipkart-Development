package com.flipkart.rest;

import com.flipkart.bean.GymCenter;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.AdminBusinessInterface;

import java.util.List;

public class AdminGMSRESTService {

    AdminBusinessInterface adminBusiness = new AdminBusiness();
    public static Response viewPendingGymRequests() {
        try{
            return Response.ok(adminBusiness.viewPendingGymRequests()).build();
        }catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }

        System.out.println("All pending Gym requests");
        System.out.println("-------------------------------------");
        return adminImpl.viewPendingGymRequests();
    }
}
