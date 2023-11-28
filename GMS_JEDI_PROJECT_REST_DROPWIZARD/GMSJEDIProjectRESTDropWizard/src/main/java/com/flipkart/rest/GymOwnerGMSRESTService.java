package com.flipkart.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


import com.flipkart.bean.Slot;
import com.flipkart.business.GymOwnerBusiness;
import com.flipkart.business.GymOwnerBusinessInterface;

@Path("/v1/gymOwner")
public class GymOwnerGMSRESTService {

    @Path("gymOwnerDetails")
    @GET
    @Produces("application/json")
    public static Response getGymOwnerDetails(@QueryParam("gymOwnerEmail") String gymOwnerEmail){
        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
        try{
            return Response.ok().entity(gymOwnerBusiness.getGymOwnerDetails(gymOwnerEmail)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }

    }
//
//    public static Response addSlots(int gymCenterId, Slot slot){
//
//    }
}
