package week2.dao;

import week2.model.Order;
import week2.model.OrderDetails;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
public interface OrderDetailsDao {

    void createOrderDetailsTable() throws SQLException;
    void dropOrderDetailsTable() throws SQLException;
    void saveOrderDetail(LocalDateTime orderDate, double totalPrice, Long orderId, Long carId) throws SQLException;
    void updateOrderDetail(Long id, LocalDateTime orderDate,double totalPrice, Long orderId, Long carId) throws SQLException;
    void deleteOrderDetailById(Long id) throws SQLException;
    OrderDetails getOrderDetailById(Long id) throws SQLException;
    List<OrderDetails> getAllOrderDetails() throws SQLException;
}
