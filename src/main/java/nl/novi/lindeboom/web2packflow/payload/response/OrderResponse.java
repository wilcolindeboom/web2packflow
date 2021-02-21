package nl.novi.lindeboom.web2packflow.payload.response;

import nl.novi.lindeboom.web2packflow.domain.OrderItem;

import javax.persistence.Column;
import java.util.List;

public class OrderResponse {

    private String sourceOrderId;
    private List<OrderItem> orderItems;

    public String getSourceOrderId() {
        return sourceOrderId;
    }

    public void setSourceOrderId(String sourceOrderId) {
        this.sourceOrderId = sourceOrderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}




