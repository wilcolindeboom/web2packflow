package nl.novi.lindeboom.web2packflow.repository;

import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {


}
