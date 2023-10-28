package week2.dao;

import week2.model.Customer;
import week2.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    public CustomerDaoImpl() {
    }
    @Override
    public void createCustomersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS customers (\n" +
                "id BIGSERIAL PRIMARY KEY NOT NULL,\n" +
                "\tname VARCHAR(100) NOT NULL,\n" +
                "\tsurname VARCHAR(100) NOT NULL,\n" +
                "\temail VARCHAR(100) NOT NULL,\n" +
                "\tphone VARCHAR(100) NOT NULL);";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
            System.out.println("Table customers created!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void dropCustomersTable() throws SQLException {
        String sql = "DROP TABLE customers;";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table customers is dropped");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveCustomer(String name, String surname, String email, String phone) throws SQLException {
        String sql = "INSERT INTO customers (name, surname, email, phone) VALUES(?, ?, ?, ?);";
        Long customerId = null;
        try (Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                customerId = resultSet.getLong("id");
                System.out.println("Customer with ID " + customerId + " saved!");
            }else{
                throw new SQLException("Save customer failed!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void updateCustomer(Long id, String name, String surname, String email, String phone) throws SQLException {
        String sql = "UPDATE customers SET name = ?, surname = ?, email = ?, phone = ? WHERE customers.id = ?;";
        try(Connection connection = Util.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
            System.out.println("Customer with id " + id + " updated!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomerById(Long id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?;";
        try(Connection connection = Util.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Customer with ID " + " deleted from DB!");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Customer getCustomerById(Long id) throws SQLException {
        Customer customer = null;
        String sql = "SELECT name, email FROM customers WHERE id = ?;";
        try (Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            customer = new Customer();
            customer.setName(resultSet.getString("name"));
            customer.setEmail(resultSet.getString("email"));
            System.out.println(customer);
        }else {
            throw new SQLException("Customer with ID " + id + " not found!");
        }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return  customer;
    }
    @Override
    public List<Customer> getAllCustomers() throws SQLException {
            List<Customer> customers = new ArrayList<>();
            String sql = "SELECT * FROM customers";
            try (Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    Customer customer = new Customer();
                  customer.setName(resultSet.getString("name"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setSurname(resultSet.getString("surname"));
                    customer.setPhone(resultSet.getString("phone"));
                    customers.add(customer);
                }
                System.out.println(customers.size() + " customers found: " + customers);
            }catch (SQLException e){
                e.printStackTrace();
            }
            return customers;
    }
}
