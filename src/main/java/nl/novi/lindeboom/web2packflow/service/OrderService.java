package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Order;

import java.util.List;

public interface OrderService {

    public abstract List<Order> getOrders();
}
