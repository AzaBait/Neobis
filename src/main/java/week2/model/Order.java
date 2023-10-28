package week2.model;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private Long customerId;
    private Long carId;
    private double totalPrice;
    private LocalDateTime orderDate;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order(Long id, Long customerId, Long carId, int totalPrice, LocalDateTime orderDate) {
        this.id = id;
        this.customerId = customerId;
        this.carId = carId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "\nOrder{" +
                " customerId=" + customerId +
                ", carId=" + carId +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                '}';
    }
}
