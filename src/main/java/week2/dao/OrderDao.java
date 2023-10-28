package week2.dao;

import week2.model.Car;
import week2.model.Order;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderDao {

    void createOrdersTable() throws SQLException;
    void dropOrdersTable() throws SQLException;
    void saveOrder(LocalDateTime orderDate, double totalPrice, Long customerId, Long carId) throws SQLException;
    void updateOrder(Long id, LocalDateTime orderDate,double totalPrice, Long customerId, Long carId) throws SQLException;
    void deleteOrderById(Long id) throws SQLException;
    Order getOrderById(Long id) throws SQLException;
    List<Order> getAllOrders() throws SQLException;
}
