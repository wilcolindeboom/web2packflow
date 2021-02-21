package nl.novi.lindeboom.web2packflow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@IdClass(nl.novi.lindeboom.web2packflow.domain.OrderItemId.class)
@Table (name = "orderitems")
public class OrderItem  {

    @ManyToOne
    @MapsId
    @JoinColumn(name = "source_order_id")
    @JsonIgnore
    private Order order;

    @Id
    @Column(nullable = false)
    private String sourceItemId;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    @JsonIgnore
    private Batch batch;

    @Column
    private String SubstrateId;

    @Column
    private String FinishName;


//getters and setters
    public String getSubstrateId() {
        return SubstrateId;
    }

    public void setSubstrateId(String substrateId) {
        SubstrateId = substrateId;
    }

    public String getFinishName() {
        return FinishName;
    }

    public void setFinishName(String finishName) {
        FinishName = finishName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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

