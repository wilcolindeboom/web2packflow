package nl.novi.lindeboom.web2packflow.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "batch",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<OrderItem> orderItems ;

    public Batch() {
    }

    public Batch( String substrateId, String finishName) {
        this.substrateId = substrateId;
        this.finishName = finishName;
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

    public void setOpen(boolean closed) {
        this.open = closed;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
}
