/**
 * 
 */
package com.flipkart.business;

import com.flipkart.DAO.PaymentDao;
import com.flipkart.DAO.PaymentDaoImpl;

/**
 * 
 */
public class PaymentBusiness implements PaymentBusinessInterface {
	PaymentDao paymentDao = new PaymentDaoImpl();
	public void makePayment(Long cardNumber,String customerEmail) {
		paymentDao.makePayment(cardNumber, customerEmail);
		System.out.println("Payment Successful .....");
	}
}
