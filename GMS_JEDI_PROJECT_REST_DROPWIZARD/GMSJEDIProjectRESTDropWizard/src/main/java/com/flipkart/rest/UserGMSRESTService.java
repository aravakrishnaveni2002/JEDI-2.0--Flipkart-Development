package com.flipkart.rest;

@Path("/v1/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserGMSRESTService
{
    @Path("registerCustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response registerCustomer(Customer customer){
        UserBusinessInterface userBusiness = new UserBusiness();
//        User user =new User();
//        user.setEmail(customer.getEmail());
//        user.setPassword(customer.getPassword());
//        user.setRoleId(3);
        try {
//            userBusiness.registerUser(user);
            userBusiness.registerCustomer(customer);
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
        return Response.ok().build();
    }
}
