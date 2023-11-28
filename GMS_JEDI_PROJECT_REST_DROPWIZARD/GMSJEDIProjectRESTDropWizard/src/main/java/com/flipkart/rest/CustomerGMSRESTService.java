package com.flipkart.rest;

@Path("/v1/customer")
public class CustomerGMSRESTService {
    CustomerBusinessInterface customerBusiness = new CustomerBusiness();
    @Path("getCustomerDetails")
    @GET
    @Produces("application/json")
    public static Response getCustomerDetails(@QueryParam("customerEmail") String customerEmail) {
        return Response.ok(customerBusiness.getCustomerDetails(customerEmail)).build();
    }
    @Path("allgyms")
    @GET
    @Produces("application/json")
    public static Response viewAllGymCentres() {
        try{return Response.ok(customerBusiness.viewAllGymCentres()).build();}
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("bookslots")
    @POST
    @Produces("application/json")
    public static Response bookSlot(@QueryParam("gymCenterId") int gymCenterId,@QueryParam("slotId") int slotId,@QueryParam("date") String date,@QueryParam("customerEmail") String customerEmail){
        BookedSlot b = customerBusiness.isAlreadyBooked(slotId,customerEmail,date);
        if(b != null) {
            try{
                return Response.ok(customerBusiness.cancelSlot(b.getId(),customerEmail)).build();
            } catch (NoDataFoundException ne){
                return Response.status(Response.Status.UNAUTHORIZED).entity(ne.getMessage()).build();
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
    @Path("isBooked")
    @GET
    @Produces("application/json")
    public static Response isAlreadyBooked(@QueryParam("slotId") int slotId,@QueryParam("customerEmail") String customerEmail,@QueryParam("date") String date) {
        return Response.ok(customerBusiness.isAlreadyBooked(slotId,customerEmail,date)).build();

    }
    @Path("cancelslot")
    @DELETE
    @Produces("application/json")
    public static Response cancelSlot(@QueryParam("bookingId") int bookingId,@QueryParam("customerEmail") String customerEmail) {
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

        try{
            return Response.ok(customerBusiness.viewAllBookings(customerEmail)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}
