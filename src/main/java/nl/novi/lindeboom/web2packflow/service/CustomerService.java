package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Customer;

public interface CustomerService {

    Customer getCustomerById(Long id);
    Customer findCustomerById(Long id);
    Customer setCustomer(Customer customer);
    Customer saveCustomer(Customer customer);
    }
