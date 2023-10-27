package week2.dao;

import week2.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    void createCustomersTable() throws SQLException;
    void dropCustomersTable() throws SQLException;
    void saveCustomer(String name, String email) throws SQLException;
    void deleteCustomerById(Long id) throws SQLException;
    Customer getCustomerById(Long id) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;

}
