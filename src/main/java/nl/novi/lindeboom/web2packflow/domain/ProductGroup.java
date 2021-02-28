package nl.novi.lindeboom.web2packflow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="product_groups")
public class ProductGroup {

    @Id
    @NotNull
    private Long id;

    @Column
    @NotNull
    private String  description;

//    @OneToOne(fetch = FetchType.LAZY,
//            optional = true)
//    @PrimaryKeyJoinColumn
@OneToMany(
        targetEntity = Batch.class,
        mappedBy = "productGroup",
        fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Batch> batches;

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "productGroup",
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderItem> orderItems ;

// getters and setters

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
