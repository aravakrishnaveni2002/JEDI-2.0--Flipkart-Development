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
    public static Response registerCustomer(CustomerRequest customerRequest){
        UserBusinessInterface userBusiness = new UserBusiness();
        try {
            Customer customer = new Customer();
            User user = new User();
            customer.setAddress(customerRequest.getAddress());
            customer.setEmail(customerRequest.getEmail());
            customer.setName(customerRequest.getName());
            customer.setPhone(customerRequest.getPhone());
            user.setEmail(customerRequest.getEmail());
            user.setPassword(customerRequest.getPassword());
            user.setRoleId(3);
            userBusiness.registerUser(user);
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
    public static Response registerGymOwner(GymOwnerRequest gymOwnerRequest){
        UserBusinessInterface userBusiness = new UserBusiness();
        try {
            GymOwner gymOwner = new GymOwner();
            User user = new User();
            gymOwner.setName(gymOwnerRequest.getName());
            gymOwner.setAddress(gymOwnerRequest.getAddress());
            gymOwner.setGstNumber(gymOwnerRequest.getGstNumber());
            gymOwner.setEmail(gymOwner.getEmail());
            gymOwner.setPhone(gymOwnerRequest.getPhone());
            gymOwner.setApproved(gymOwnerRequest.isApproved());
            user.setEmail(gymOwnerRequest.getEmail());
            user.setPassword(gymOwnerRequest.getPassword());
            user.setRoleId(2);
            userBusiness.registerUser(user);
            userBusiness.registerGymOwner(gymOwner);
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
        return Response.ok().entity("GymOwner Registered Successfully").build();
    }
}
