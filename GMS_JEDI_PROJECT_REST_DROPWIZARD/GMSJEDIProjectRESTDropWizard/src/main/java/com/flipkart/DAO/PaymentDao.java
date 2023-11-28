package com.flipkart.DAO;

public interface PaymentDao {

    public void makePayment(Long cardNumber,String customerEmail);
}
