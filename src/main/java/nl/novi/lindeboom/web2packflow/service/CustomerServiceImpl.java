package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Customer;
import nl.novi.lindeboom.web2packflow.domain.Order;
import nl.novi.lindeboom.web2packflow.exception.RecordNotFoundException;
import nl.novi.lindeboom.web2packflow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            return findCustomerById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }


    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer setCustomer(Customer customer) {
        if(findCustomerById(customer.getId()) == null) {
            return saveCustomer(customer);
        }
        else {
            return getCustomerById(customer.getId());
        }
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}
