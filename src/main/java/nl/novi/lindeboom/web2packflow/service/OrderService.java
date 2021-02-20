package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;

import java.text.ParseException;
import java.util.List;

public interface OrderService {

    List<Order> getOrders();
    Order getOrderById(String id);
    Order saveOrder(Order order);

}
