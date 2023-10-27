package week2;

import week2.dao.CustomerDaoImpl;
import week2.util.Util;

import java.sql.SQLException;

public class LuxCars {

    public static void main(String[] args) throws SQLException {
        //Util.connection();

        CustomerDaoImpl cdao = new CustomerDaoImpl();
//        cdao.createCustomersTable();
//        cdao.saveCustomer("aza", "aza@mail.com");
 //       cdao.dropCustomersTable();
//        cdao.getCustomerById(1L);
        cdao.getAllCustomers();
    }
}
