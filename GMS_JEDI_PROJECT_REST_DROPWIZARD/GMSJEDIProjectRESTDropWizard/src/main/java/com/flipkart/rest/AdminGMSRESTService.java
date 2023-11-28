package com.flipkart.rest;

import com.flipkart.bean.*;
import com.flipkart.business.*;

import java.util.List;

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
}
