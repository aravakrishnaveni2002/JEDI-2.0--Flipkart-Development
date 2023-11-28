package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.flipkart.bean.*;
import com.flipkart.business.*;
@Path("/v1/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserGMSRESTService
{
    @Path("registerCustomer")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response registerCustomer(Customer customer){
        UserBusinessInterface userBusiness = new UserBusiness();
        try {
//            userBusiness.registerUser(user);
            userBusiness.registerCustomer(customer);
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
        return Response.ok().entity("Customer Registered Successfully").build();
    }

    @Path("registerGymOwner")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response registerGymOwner(GymOwner gymOwner){
        UserBusinessInterface userBusiness = new UserBusiness();
        try {
//            userBusiness.registerUser(user);
            userBusiness.registerGymOwner(gymOwner);
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
        return Response.ok().entity("GymOwner Registered Successfully").build();
    }
}
