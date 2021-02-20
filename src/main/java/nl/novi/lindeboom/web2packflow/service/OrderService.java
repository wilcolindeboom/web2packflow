package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();
    Order getOrderById(String id);
    String saveOrder(Order order);

}
