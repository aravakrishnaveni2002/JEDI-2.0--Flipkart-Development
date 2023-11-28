package com.flipkart.rest;

import com.flipkart.bean.*;
import com.flipkart.business.*;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/v1/admin")
public class AdminGMSRESTService {

    @Path("allApprovedGymOwners")
    @GET
    @Produces("application/json")
    public static Response viewAllApprovedGymOwners() {
        AdminBusinessInterface adminBusiness = new AdminBusiness();
        try{
            return Response.ok(adminBusiness.viewAllApprovedGymOnwers()).build();
        }catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("allPendingGymRequests")
    @GET
    @Produces("application/json")
    public static Response viewPendingGymRequests() {
        AdminBusinessInterface adminBusiness = new AdminBusiness();
        try{
            return Response.ok(adminBusiness.viewPendingGymRequests()).build();
        }catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("allPendingGymOwnerRequests")
    @GET
    @Produces("application/json")
    public static Response viewPendingGymOwnerRequests() {
        AdminBusinessInterface adminBusiness = new AdminBusiness();
        try{
            return Response.ok(adminBusiness.viewPendingGymOwnerRequests()).build();
        }catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("allApprovedGyms")
    @GET
    @Produces("application/json")
    public static Response viewAllApprovedGyms() {
        AdminBusinessInterface adminBusiness = new AdminBusiness();
        try{
            return Response.ok(adminBusiness.viewAllApprovedGyms()).build();
        }catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("approveGym")
    @PUT
    public static String approveGymRegistration(@QueryParam("gymId") int gymId){

        try{
            AdminBusinessInterface adminBusiness = new AdminBusiness();
            adminBusiness.approveGymRegistration(gymId);
            return "Gym Approved!";
        }catch(Exception exception){
            return  exception.getMessage();
        }
    }

    @Path("approveGymOwner")
    @PUT
    public static String approveGymOwnerRegistration(@QueryParam("ownerId") int ownerId){

        try{
            AdminBusinessInterface adminBusiness = new AdminBusiness();
            adminBusiness.approveGymOwnerRegistration(ownerId);
            return "GymOwner Approved!";
        }catch(Exception exception){
            return  exception.getMessage();
        }
    }


}
