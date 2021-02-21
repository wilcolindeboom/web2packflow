package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.converter.OrderConverter;
import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.exception.RecordNotFoundException;
import nl.novi.lindeboom.web2packflow.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String id) {
        if (orderRepository.existsById(id)) {
            return findOrderById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Order findOrderById(String id) {
     return orderRepository.findById(id).orElse(null);
    }



    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }


}
