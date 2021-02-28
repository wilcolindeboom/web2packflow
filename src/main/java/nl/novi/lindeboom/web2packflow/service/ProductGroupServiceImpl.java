package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import nl.novi.lindeboom.web2packflow.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductGroupServiceImpl implements ProductGroupService{

    @Autowired
    private ProductGroupRepository productGroupRepository;



}
