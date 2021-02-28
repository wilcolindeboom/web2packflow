package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


}
