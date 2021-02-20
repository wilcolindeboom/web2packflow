package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;

public interface OrderProcessService {

    String processOrder(OrderRequest orderRequest) ;

}
