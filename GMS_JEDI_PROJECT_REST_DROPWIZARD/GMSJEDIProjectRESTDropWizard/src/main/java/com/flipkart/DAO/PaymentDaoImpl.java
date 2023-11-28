package com.flipkart.DAO;

import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDaoImpl implements PaymentDao{
    Connection connection = null;
    PreparedStatement statement = null;
    public void makePayment(Long cardNumber,String customerEmail){

        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(SQLQueries.MAKE_PAYMENT);
            statement.setLong(1,cardNumber);
            statement.setString(2,customerEmail);
            statement.executeUpdate();
            statement.close();

        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
    }
}
