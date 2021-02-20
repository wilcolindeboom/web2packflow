package nl.novi.lindeboom.web2packflow.converter;

import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import org.springframework.stereotype.Component;


@Component
public class OrderConverter {

    public Order dtoToEntity(OrderRequest orderRequest) {
        Order newOrder = new Order();
        newOrder.setSourceOrderId(orderRequest.getSourceOrderId());
        newOrder.setOrderItems(orderRequest.getOrderItems());
        return newOrder;
    }

}
