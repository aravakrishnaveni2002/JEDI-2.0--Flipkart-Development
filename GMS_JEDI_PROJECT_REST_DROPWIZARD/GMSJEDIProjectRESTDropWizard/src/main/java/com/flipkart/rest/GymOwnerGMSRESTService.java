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
    @Path("viewAllSlots")
    @GET
    @Produces("application/json")
    public static Response viewAllSlots(@QueryParam("gymCenterId") int gymCenterId){
        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
//        System.out.println("Listing all Slots in  GymCenter");
//        System.out.println("-------------------------------------");
        try{
            return Response.ok(gymOwnerBusiness.viewAllSlots(gymCenterId)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("isApprovedGymOwner")
    @GET
    @Produces("application/json")
    public static Response isApproved(@QueryParam("gymOwnerEmail") String gymOwnerEmail) {
        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
        try{
             return Response.ok().entity(gymOwnerBusiness.isApproved(gymOwnerEmail)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("isApprovedGymCenter")
    @GET
    @Produces("application/json")
    public static Response isApproved(@QueryParam("gymCenterId") int gymCenterId)
    {
        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
        try
        {
            return Response.ok().entity(gymOwnerBusiness.isApproved(gymCenterId)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }

    }
//    @Path("addSlot")
//    @POST
//    @Produces("application/json")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public static Response addSlots(@QueryParam("gymCenterId") int gymCenterId,Slot slot) {
//        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
//        try
//        {
//             gymOwnerBusiness.addSlots(gymCenterId, slot);
//            return Response.ok().entity("Slot added successfully").build();
//        }
//        catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//
//    }
    @Path("addGym")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response addGym(GymCenter gymCenter) {
        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
        try
        {
            gymOwnerBusiness.addGym(gymCenter);
            return Response.ok().entity("GymCenter added successfully").build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }

    }
    @Path("createSlot")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response createSlot(Slot slot){

        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
        try
        {
            gymOwnerBusiness.createSlot(slot);
            return Response.ok().entity("Slot added successfully").build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }


    }

    @Path("viewAllGymCenters")
    @GET
    @Produces("application/json")
    public static Response viewAllGymCenters(@QueryParam("gymOwnerEmail") String gymOwnerEmail){
        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
//        System.out.println("Listing all GymCenter");
//        System.out.println("-------------------------------------");
        try{
            return Response.ok(gymOwnerBusiness.viewAllGymCenters(gymOwnerEmail)).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("viewAllApprovedGymCenters")
    @GET
    @Produces("application/json")
    public static Response viewAllApprovedGymCenters(@QueryParam("gymOwnerEmail") String gymOwnerEmail){
//        System.out.println("Listing all approved GymCenter");
//        System.out.println("-------------------------------------");
        try{
            return Response.ok(gymOwnerDao.viewAllApprovedGymCenters(gymOwnerEmail)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }

    }

}
