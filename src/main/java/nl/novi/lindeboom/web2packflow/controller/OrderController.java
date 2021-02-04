package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderservice;



    @GetMapping(value = "")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.status(200).body(orderservice.getOrders());
    }
}
