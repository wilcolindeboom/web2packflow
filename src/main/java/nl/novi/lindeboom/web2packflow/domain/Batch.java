package nl.novi.lindeboom.web2packflow.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="batches")
public class Batch {

    @Id
    @Column(nullable = false, unique = true)
    private Long batchId;

    @Column
    private boolean closed;

//    @OneToMany(
//            targetEntity = OrderItem.class,
//            mappedBy = "batchId",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER)
//    private List<OrderItem> orderItems = new ArrayList<>();

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }
//
//    public void addOrderItems(OrderItem orderItem) {
//        this.orderItems.add(orderItem);
//    }

}
