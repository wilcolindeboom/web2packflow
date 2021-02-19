package nl.novi.lindeboom.web2packflow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(nl.novi.lindeboom.web2packflow.domain.OrderItemId.class)
@Table (name = "orderitems")
public class OrderItem implements Serializable {

    @Id
    @Column(nullable = false)
    private String sourceItemId;

    @Id
    @Column(nullable = false)
    @JsonIgnore
    private String sourceOrderId;
//
//    @Column
//    private Long batchId;

////    @ManyToOne
////    @JoinColumn(columnDefinition = "batchId")
//    private Batch batch;

    @ManyToOne
    @JoinColumn(columnDefinition = "sourceOrderId")
    @JsonIgnore
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getSourceOrderId() {
        return sourceOrderId;
    }

    public void setSourceOrderId(String sourceOrderId) {
        this.sourceOrderId = sourceOrderId;
    }

    public String getSourceItemId() {
        return sourceItemId;
    }

    public void setSourceItemId(String sourceItemId) {
        this.sourceItemId = sourceItemId;
    }

//    public Long getBatchId() {
//        return batchId;
//    }
//
//    public void setBatchId(Long batchId) {
//        this.batchId = batchId;
//    }

//    public Batch getBatch() {
//        return batch;
//    }
//
//    public void setBatch(Batch batch) {
//        this.batch = batch;
//    }
}

