package nl.novi.lindeboom.web2packflow.repository;

import nl.novi.lindeboom.web2packflow.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, String> {
}
