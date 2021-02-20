package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import nl.novi.lindeboom.web2packflow.service.OrderProcessService;
import nl.novi.lindeboom.web2packflow.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderservice;

    @Autowired
    private OrderProcessService orderProcessService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.status(200).body(orderservice.getOrders());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") String id) {
        System.out.println("get order endpoint");
        return ResponseEntity.status(200).body(orderservice.getOrderById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveOrder(@RequestBody Order orderRequest) {
        String newOrderId = orderservice.saveOrder(orderRequest).getSourceOrderId();
        return new ResponseEntity<>(newOrderId, HttpStatus.CREATED);
    }


    @PostMapping(value = "test")
    public ResponseEntity<Object> inputOrder(@RequestBody OrderRequest orderRequest) {
        String newOrderId = orderProcessService.processOrder(orderRequest);
        return new ResponseEntity<>(newOrderId, HttpStatus.CREATED);
    }

}
