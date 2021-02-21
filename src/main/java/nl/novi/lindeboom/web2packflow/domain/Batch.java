package nl.novi.lindeboom.web2packflow.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="batches")
public class Batch {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private Long id;

    @Column
    private boolean open = true;

    @Column
    private String substrateId;

    @Column
    private String finishName;

    @Column
    private String storeFrontId;

    @Column
    private Date shippingDate;

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "batch",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<OrderItem> orderItems ;

//    @OneToOne(fetch = FetchType.EAGER,
//            optional = false,
//            cascade =  CascadeType.ALL)
////    @PrimaryKeyJoinColumn(name = "product_group_id")
//    @JoinColumn(name = "product_group_id", nullable = false)
//    private ProductGroup productGroup;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroup;

    public Batch() {
    }

    public Batch( String substrateId, String finishName, ProductGroup productGroup) {
        this.substrateId = substrateId;
        this.finishName = finishName;
        this.productGroup = productGroup;
    }


    //getters and setters

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

    public String getStoreFrontId() {
        return storeFrontId;
    }

    public void setStoreFrontId(String storeFrontId) {
        this.storeFrontId = storeFrontId;
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

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
}
