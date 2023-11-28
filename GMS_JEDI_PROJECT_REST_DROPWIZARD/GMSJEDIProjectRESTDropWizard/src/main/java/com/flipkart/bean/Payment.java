/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Payment {
	
	private long cardNumber;
	private String customerEmail;
//	private int cvv;

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCustomerName() {
		return customerEmail;
	}

	public void setCustomerName(String customerEmail) {
		this.customerEmail = customerEmail;
	}

//	public int getCvv() {
//		return cvv;
//	}
//
//	public void setCvv(int cvv) {
//		this.cvv = cvv;
//	}
	
}
