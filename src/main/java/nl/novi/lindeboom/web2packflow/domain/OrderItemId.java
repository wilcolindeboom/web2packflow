package nl.novi.lindeboom.web2packflow.domain;

import java.io.Serializable;

public class OrderItemId implements Serializable {

    private String sourceItemId;
    private Order order;


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
