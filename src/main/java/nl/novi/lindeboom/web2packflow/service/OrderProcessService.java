package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import nl.novi.lindeboom.web2packflow.payload.response.OrderResponse;

import java.util.List;

public interface OrderProcessService {

    String processOrder(OrderRequest orderRequest) ;
    OrderResponse getOrder(String id);
    List<OrderResponse> getOrders();

}
