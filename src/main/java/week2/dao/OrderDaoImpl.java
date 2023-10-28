package week2.dao;

import week2.model.Car;
import week2.model.Order;
import week2.util.Util;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao{
    public OrderDaoImpl() {
    }

    @Override
    public void createOrdersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS orders(\n" +
                " id BIGSERIAL PRIMARY KEY NOT NULL,\n" +
                "\torder_date TIMESTAMP DEFAULT NOW() NOT NULL,\n" +
                "\ttotal_price DOUBLE PRECISION NOT NULL,\n" +
                "\tcustomer_id BIGINT NOT NULL,\n" +
                "\tcar_id BIGINT NOT NULL,\n" +
                "\tCONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(id),\n" +
                "\tCONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars(id));";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table orders created!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void dropOrdersTable() throws SQLException {
        String sql = "DROP TABLE orders;";
        try (Connection connection = Util.connection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table orders is dropped!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveOrder(LocalDateTime orderDate, double totalPrice, Long customerId, Long carId) throws SQLException {
        String sql = "INSERT INTO orders (order_date, total_price, customer_id, car_id) VALUES (?, ?, ?, ?)";
        Long orderId = null;
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setDouble(2, totalPrice);
            preparedStatement.setLong(3, customerId);
            preparedStatement.setLong(4, carId);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                orderId = resultSet.getLong("id");
                System.out.println("Order with ID " + orderId + " saved!");
            }else {
                throw new SQLException("Save new order failed!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Long id, LocalDateTime orderDate, double totalPrice, Long customerId, Long carId) throws SQLException {
    String sql = "UPDATE orders SET order_date = ?, total_price = ?, customer_id = ?, car_id = ? WHERE orders.id = ?;";
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
    try(Connection connection = Util.connection();
    PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        preparedStatement.setLong(3, customerId);
        preparedStatement.setLong(4, carId);
        preparedStatement.setDouble(2, totalPrice);
        preparedStatement.setTimestamp(1, timestamp);
        preparedStatement.setLong(5, id);
        preparedStatement.executeUpdate();
        System.out.println("Order with id " + id + " updated!");
    }catch (SQLException e){
        e.printStackTrace();
    }
    }

    @Override
    public void deleteOrderById(Long id) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Order with ID " + " deleted from DB!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(Long id) throws SQLException {
        String sql = "SELECT order_date, total_price, customer_id, car_id FROM orders WHERE id = ?";
        Order order = null;
        try (Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                order = new Order();
                order.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
                order.setTotalPrice(resultSet.getDouble("total_price"));
                order.setCustomerId(resultSet.getLong("customer_id"));
                order.setCarId(resultSet.getLong("car_id"));
                System.out.println(order);
            }else {
                throw new SQLException("Order with ID " + id + " not found!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Connection connection = Util.connection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
                order.setTotalPrice(resultSet.getDouble("total_price"));
                order.setCustomerId(resultSet.getLong("customer_id"));
                order.setCarId(resultSet.getLong("car_id"));
                orders.add(order);
            }System.out.println(orders.size() + " orders found: " + orders);
        }
        return orders;
    }
}
