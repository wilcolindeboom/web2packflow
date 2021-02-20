package nl.novi.lindeboom.web2packflow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(nl.novi.lindeboom.web2packflow.domain.OrderItemId.class)
@Table (name = "orderitems")
public class OrderItem  {

    @ManyToOne
    @MapsId
    @JoinColumn(name = "source_order_id")
    @JsonIgnore
//    @JsonIgnoreProperties("orderItems")
    private Order order;

    @Id
    @Column(nullable = false)
    private String sourceItemId;

//    @Id
//    @Column(nullable = false)
//    @JsonIgnore
//    private String sourceOrderId;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    @JsonIgnore
    private Batch batch;



    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//    public String getSourceOrderId() {
//        return sourceOrderId;
//    }
//
//    public void setSourceOrderId(String sourceOrderId) {
//        this.sourceOrderId = sourceOrderId;
//    }

    public String getSourceItemId() {
        return sourceItemId;
    }

    public void setSourceItemId(String sourceItemId) {
        this.sourceItemId = sourceItemId;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}

