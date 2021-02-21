package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.converter.OrderConverter;
import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderProcessServiceImpl implements OrderProcessService {

    @Autowired
    private OrderConverter orderConverter;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BatchService batchService;


    @Override
    public String processOrder(OrderRequest orderRequest) {
        if(orderService.findOrderById(orderRequest.getSourceOrderId()) == null) {
            Order newOrder = orderConverter.OrderRequestToOrder(orderRequest);
            List<OrderItem> newOrderItems = newOrder.getOrderItems();
            for (OrderItem item : newOrderItems) {
                item.setOrder(newOrder);
                item.setBatch(batchService.getBatch(item));
            }
            newOrder.setOrderItems(newOrderItems);
            String savedOrderId = orderService.saveOrder(newOrder).getSourceOrderId();
            return ("Order " + savedOrderId + "  processed and saved successfully!");
        }
        else
            throw new DataIntegrityViolationException("Order "+ orderRequest.getSourceOrderId() +" already exists in the system!");

    }

}

