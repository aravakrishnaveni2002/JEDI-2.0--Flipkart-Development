package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.flipkart.business.*;
import com.flipkart.bean.*;
@Path("/v1/customer")
public class CustomerGMSRESTService {

    @Path("getCustomerDetails")
    @GET
    @Produces("application/json")
    public static Response getCustomerDetails(CustomerRequest customerRequest) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            return Response.ok().entity(customerBusiness.getCustomerDetails(customerRequest.getEmail())).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }

    }
    @Path("allGyms")
    @GET
    @Produces("application/json")
    public static Response viewAllGymCentres() {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            return Response.ok().entity(customerBusiness.viewAllGymCentres()).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("bookSlot")
    @POST
    @Produces("application/json")
    public static Response bookSlot(CustomerRequest customerRequest){
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        BookedSlot b = customerBusiness.isAlreadyBooked(customerRequest.getSlotId(), customerRequest.getEmail(), customerRequest.getDate());
        if(b != null) {
            try{
                return Response.ok(customerBusiness.cancelSlot(b.getId(), customerRequest.getEmail())).build();
            } catch (Exception exception){
                return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
            }
        }

        try {
            if(customerBusiness.bookSlot(customerRequest.getGymCenterId(), customerRequest.getSlotId(), customerRequest.getDate(), customerRequest.getEmail()) == true) {

               return Response.ok().entity("Slot Booked").build();
            }
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
        return Response.ok().entity("No Data Found").build();
    }
    @Path("isAlreadyBooked")
    @GET
    @Produces("application/json")
    public static Response isAlreadyBooked(CustomerRequest customerRequest) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            return Response.ok().entity(customerBusiness.isAlreadyBooked(customerRequest.getSlotId(), customerRequest.getEmail(), customerRequest.getDate())).build();
        } catch (Exception exception){
            return Response.ok(customerBusiness.isAlreadyBooked(customerRequest.getSlotId(), customerRequest.getEmail(), customerRequest.getDate())).build();
        }


    }
    @Path("cancelSlot")
    @DELETE
    @Produces("application/json")
    public static Response cancelSlot(CustomerRequest customerRequest) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            if(customerBusiness.cancelSlot(customerRequest.getBookingId(), customerRequest.getEmail()) == true) {
                return Response.ok().entity("Slot Cancelled").build();
            }
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
        return Response.ok().entity("No Data Found").build();
    }
    @Path("viewAllBookings")
    @GET
    @Produces("application/json")
    public static Response viewAllBookings(CustomerRequest customerRequest) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            return Response.ok(customerBusiness.viewAllBookings(customerRequest.getEmail())).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}
