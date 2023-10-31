package week2.dao;

import week2.model.Order;
import week2.model.OrderDetails;
import week2.util.Util;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao{
    @Override
    public void createOrderDetailsTable() throws SQLException {
    String sql = "CREATE TABLE orderDetails (\n" +
            "    id SERIAL PRIMARY KEY NOT NULL,\n" +
            "    order_id bigint NOT NULL,\n" +
            "    car_id bigint NOT NULL,\n" +
            "    total_price double precision,\n" +
            "    order_date timestamp DEFAULT NOW() NOT NULL,\n" +
            "\tCONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders(id),\n" +
            "\tCONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars(id)\n" +
            ");";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table orderDetails created!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void dropOrderDetailsTable() throws SQLException {
        String sql = "DROP TABLE orderDetails;";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table orderDetails is dropped!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveOrderDetail(LocalDateTime orderDate, double totalPrice, Long orderId, Long carId) throws SQLException {
        String sql = "INSERT INTO orderDetails (order_date, total_price, order_id, car_id) VALUES (?, ?, ?, ?)";
        Long orderDetailId = null;
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setDouble(2, totalPrice);
            preparedStatement.setLong(3, orderId);
            preparedStatement.setLong(4, carId);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                orderDetailId = resultSet.getLong("id");
                System.out.println("OrderDetail with ID " + orderDetailId + " saved!");
            }else {
                throw new SQLException("Save new orderDetail failed!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderDetail(Long id, LocalDateTime orderDate, double totalPrice, Long orderId, Long carId) throws SQLException {
        String sql = "UPDATE orderDetails SET order_date = ?, total_price = ?, order_id, car_id, WHERE orderDetails.id = ?;";
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        try(Connection connection = Util.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDouble(2, totalPrice);
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setLong(3, orderId);
            preparedStatement.setLong(4, carId);
            preparedStatement.executeUpdate();
            System.out.println("OrderDetail with id " + id + " updated!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderDetailById(Long id) throws SQLException {
        String sql = "DELETE FROM orderDetails WHERE id = ?";
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("OrderDetail with ID " + " deleted from DB!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public OrderDetails getOrderDetailById(Long id) throws SQLException {
        String sql = "SELECT order_id, order_date, car_id, total_price FROM orderDetails WHERE id = ?";
        OrderDetails orderDetail = null;
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                orderDetail = new OrderDetails();
                orderDetail.setOrderId(resultSet.getLong("order_id"));
                orderDetail.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
                orderDetail.setCarId(resultSet.getLong("car_id"));
                orderDetail.setTotalPrice(resultSet.getDouble("total_price"));
                System.out.println(orderDetail);
            }else {
                throw new SQLException("OrderDetail with ID " + id + " not found!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orderDetail;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() throws SQLException {
        List<OrderDetails> orderDetails = new ArrayList<>();
        String sql = "SELECT * FROM orderDetails";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                OrderDetails orderDetail = new OrderDetails();
                orderDetail.setOrderId(resultSet.getLong("order_id"));
                orderDetail.setCarId(resultSet.getLong("car_id"));
                orderDetail.setTotalPrice(resultSet.getDouble("total_price"));
                orderDetail.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
                orderDetails.add(orderDetail);
            }System.out.println(orderDetails.size() + " orders found: " + orderDetails);
        }
        return orderDetails;
    }
}
