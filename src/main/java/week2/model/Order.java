package week2.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private List<OrderDetails> orderDetailsL;
    private Long customerID;
    private LocalDateTime orderDate;
    public Order(Long id, List<OrderDetails> orderDetailsL, Long customerID, LocalDateTime orderDate) {
        this.id = id;
        this.orderDetailsL = orderDetailsL;
        this.customerID = customerID;
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

    public List<OrderDetails> getOrderDetailsL() {
        return orderDetailsL;
    }

    public void setOrderDetailsL(List<OrderDetails> orderDetailsL) {
        this.orderDetailsL = orderDetailsL;
    }
    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDetailsL=" + orderDetailsL +
                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
                '}';
    }
}
