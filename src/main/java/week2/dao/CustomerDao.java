package week2.dao;

import week2.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    void createCustomersTable() throws SQLException;
    void dropCustomersTable() throws SQLException;
    void saveCustomer(String name, String surname, String email, String phone) throws SQLException;
    void updateCustomer(Long id, String name, String surname, String email, String phone) throws SQLException;
    void deleteCustomerById(Long id) throws SQLException;
    Customer getCustomerById(Long id) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;

}
