package nl.novi.lindeboom.web2packflow.payload.response;


import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import java.util.Date;
import java.util.List;

public class BatchOverviewResponse {

    private Long id;
    private boolean open;
    private String substrateId;
    private String finishName;
    private Date shippingDate;
    private List<OrderItem> orderItems;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getSubstrateId() {
        return substrateId;
    }

    public void setSubstrateId(String substrateId) {
        this.substrateId = substrateId;
    }

    public String getFinishName() {
        return finishName;
    }

    public void setFinishName(String finishName) {
        this.finishName = finishName;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
