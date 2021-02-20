package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.converter.OrderConverter;
import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
        Order newOrder = orderConverter.dtoToEntity(orderRequest);
        Batch newBatch = batchService.createBatch();
        List<OrderItem> newOrderItems = newOrder.getOrderItems();
        for (OrderItem temp : newOrderItems) {
            temp.setBatch(newBatch);
            temp.setOrder(newOrder);
        }
        newOrder.setOrderItems(newOrderItems);
        return orderService.saveOrder(newOrder).getSourceOrderId();
    }
}

