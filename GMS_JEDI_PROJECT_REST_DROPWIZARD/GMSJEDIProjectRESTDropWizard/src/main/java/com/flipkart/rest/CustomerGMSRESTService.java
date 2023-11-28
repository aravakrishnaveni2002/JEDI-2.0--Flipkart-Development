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
    public static Response getCustomerDetails(@QueryParam("customerEmail") String customerEmail) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            return Response.ok().entity(customerBusiness.getCustomerDetails(customerEmail)).build();
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
    public static Response bookSlot(@QueryParam("gymCenterId") int gymCenterId,@QueryParam("slotId") int slotId,@QueryParam("date") String date,@QueryParam("customerEmail") String customerEmail){
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        BookedSlot b = customerBusiness.isAlreadyBooked(slotId,customerEmail,date);
        if(b != null) {
            try{
                return Response.ok(customerBusiness.cancelSlot(b.getId(),customerEmail)).build();
            } catch (Exception exception){
                return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
            }
        }

        try {
            if(customerBusiness.bookSlot(gymCenterId, slotId, date, customerEmail) == true) {

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
    public static Response isAlreadyBooked(@QueryParam("slotId") int slotId,@QueryParam("customerEmail") String customerEmail,@QueryParam("date") String date) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            return Response.ok().entity(customerBusiness.isAlreadyBooked(slotId,customerEmail,date)).build();
        } catch (Exception exception){
            return Response.ok(customerBusiness.isAlreadyBooked(slotId,customerEmail,date)).build();
        }


    }
    @Path("cancelSlot")
    @DELETE
    @Produces("application/json")
    public static Response cancelSlot(@QueryParam("bookingId") int bookingId,@QueryParam("customerEmail") String customerEmail) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            if(customerBusiness.cancelSlot(bookingId , customerEmail) == true) {
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
    public static Response viewAllBookings(@QueryParam("customerEmail") String customerEmail) {
        CustomerBusinessInterface customerBusiness = new CustomerBusiness();
        try{
            return Response.ok(customerBusiness.viewAllBookings(customerEmail)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}
