package com.flipkart.rest;

@Path("/v1/user")
public class UserGMSRESTService
{
    @Path("registerCustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static void registerCustomer(Customer customer){
        UserBusinessInterface userBusiness = new UserBusiness();
        User user =new User();
        user.setEmail(customer.getEmail());
        user.setPassword(customer.getPassword());
        user.setRoleId(3);
        try {
            userBusiness.registerUser(user);
            userBusiness.registerCustomer(customer);
        } catch (Exception e) {

        }
    }
}
