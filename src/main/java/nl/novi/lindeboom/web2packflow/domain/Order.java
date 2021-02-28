package nl.novi.lindeboom.web2packflow.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @Column(nullable = false, unique = true)
    private String sourceOrderId;

    @Column
    private Integer storeFrontId;

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<OrderItem> orderItems ;

    @ManyToOne
//    @NotNull
    @JoinColumn(name = "customer_id")
    private Customer customer;


//getters and setters

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
