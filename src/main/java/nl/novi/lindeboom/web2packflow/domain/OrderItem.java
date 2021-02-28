package nl.novi.lindeboom.web2packflow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

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

//    @Column(columnDefinition = "serial")
    @Column
    private String substrateId;
    @Column
    private Integer quantity;
    @Column
    private String finishName;
    @Column
    private java.sql.Date shippingDate;


    @ManyToOne
    @NotNull
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroup;


//getters and setters

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

    public String getSubstrateId() {
        return substrateId;
    }

    public void setSubstrateId(String substrateId) {
        this.substrateId = substrateId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
}

