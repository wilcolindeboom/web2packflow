package nl.novi.lindeboom.web2packflow.payload.request;

import nl.novi.lindeboom.web2packflow.domain.Customer;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;

import java.util.List;


public class OrderRequest {

    private String sourceOrderId;
    private Integer storeFrontId;
    private List<OrderItem> orderItems;
    private Customer customer;


    // getters and setters


    public String getSourceOrderId() {
        return sourceOrderId;
    }

    public void setSourceOrderId(String sourceOrderId) {
        this.sourceOrderId = sourceOrderId;
    }

    public Integer getStoreFrontId() {
        return storeFrontId;
    }

    public void setStoreFrontId(Integer storeFrontId) {
        this.storeFrontId = storeFrontId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
