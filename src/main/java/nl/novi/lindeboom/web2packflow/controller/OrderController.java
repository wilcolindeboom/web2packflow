package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.payload.request.OrderRequest;
import nl.novi.lindeboom.web2packflow.service.OrderProcessService;
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
    private OrderProcessService orderProcessService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.status(200).body(orderProcessService.getOrders());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") String id) {
        return ResponseEntity.status(200).body(orderProcessService.getOrder(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> inputOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderProcessService.processOrder(orderRequest), HttpStatus.CREATED);
    }

}
