package nl.novi.lindeboom.web2packflow.converter;

import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import nl.novi.lindeboom.web2packflow.payload.response.OrderResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/** Converts OrderRequest to Order and viceversa
 */

@Component
public class OrderConverter {

    public Order OrderRequestToOrder(OrderRequest orderRequest) {
        Order newOrder = new Order();
        newOrder.setSourceOrderId(orderRequest.getSourceOrderId());
        newOrder.setStoreFrontId(orderRequest.getStoreFrontId());
        newOrder.setOrderItems(orderRequest.getOrderItems());
        newOrder.setCustomer(orderRequest.getCustomer());
        return newOrder;
    }

    public List<Order> OrderRequestToOrder(List<OrderRequest> orderRequests) {
       return orderRequests.stream().map(orderRequest -> OrderRequestToOrder(orderRequest)).collect(Collectors.toList());
    }

    public OrderResponse OrderToOrderResponse(Order order) {
        OrderResponse newOrderResponse = new OrderResponse();
        newOrderResponse.setSourceOrderId(order.getSourceOrderId());
        newOrderResponse.setOrderItems(order.getOrderItems());
        newOrderResponse.setCustomer(order.getCustomer());
        return newOrderResponse;
    }

    public List<OrderResponse> OrderToOrderResponse(List<Order> orders) {
        return orders.stream().map(order -> OrderToOrderResponse(order)).collect(Collectors.toList());
    }


}
