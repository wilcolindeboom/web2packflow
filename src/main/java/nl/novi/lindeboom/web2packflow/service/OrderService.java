package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import nl.novi.lindeboom.web2packflow.payload.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();
    Order getOrderById(String id);
    Order saveOrder(Order order);
    Order findOrderById(String id);
    List<OrderResponse> getOrderResponse();
    OrderResponse getOrder(String id);
    String processOrder(OrderRequest orderRequest) ;

}
