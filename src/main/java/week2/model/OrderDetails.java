package week2.model;

import java.time.LocalDateTime;

public class OrderDetails {

    private Long id;
    private Long orderId;
    private Long carId;
    private double totalPrice;
    private LocalDateTime orderDate;

    public OrderDetails() {
    }

    public OrderDetails(Long id, Long orderId, Long carId, double totalPrice, LocalDateTime orderDate) {
        this.id = id;
        this.orderId = orderId;
        this.carId = carId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", carId=" + carId +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                '}';
    }
}
