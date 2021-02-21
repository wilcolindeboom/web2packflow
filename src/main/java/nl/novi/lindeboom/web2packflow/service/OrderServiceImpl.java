package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.converter.OrderConverter;
import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.exception.RecordNotFoundException;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import nl.novi.lindeboom.web2packflow.payload.response.OrderResponse;
import nl.novi.lindeboom.web2packflow.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderConverter orderConverter;
    @Autowired
    private BatchService batchService;

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

    @Override
    public List<OrderResponse> getOrderResponse() {
        return orderConverter.OrderToOrderResponse(getOrders());
    }

    @Override
    public OrderResponse getOrder(String id) {
        return orderConverter.OrderToOrderResponse(getOrderById(id));
    }

    @Override
    public String processOrder(OrderRequest orderRequest) {
        if(findOrderById(orderRequest.getSourceOrderId()) == null) {
            Order newOrder = orderConverter.OrderRequestToOrder(orderRequest);
            List<OrderItem> newOrderItems = newOrder.getOrderItems();
            for (OrderItem item : newOrderItems) {
                item.setOrder(newOrder);
                item.setBatch(batchService.getBatch(item, newOrder.getStoreFrontId()));
            }
            newOrder.setOrderItems(newOrderItems);
            String savedOrderId = saveOrder(newOrder).getSourceOrderId();
            return ("Order " + savedOrderId + "  processed and saved successfully!");
        }
        else
            throw new DataIntegrityViolationException("Order "+ orderRequest.getSourceOrderId() +
                    " already exists in the system!");

    }



}
