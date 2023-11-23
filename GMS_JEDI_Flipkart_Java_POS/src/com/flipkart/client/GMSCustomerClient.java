/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.CustomerBusiness;

/**
 * 
 */
public class GMSCustomerClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerBusiness customerBusiness = new CustomerBusiness();
		customerBusiness.register();
		customerBusiness.login();
		customerBusiness.viewCentres();
		customerBusiness.cancelSlot();
	}

}
