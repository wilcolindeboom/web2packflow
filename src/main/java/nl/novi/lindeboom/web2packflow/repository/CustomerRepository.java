package nl.novi.lindeboom.web2packflow.repository;

import nl.novi.lindeboom.web2packflow.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
