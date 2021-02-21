package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import nl.novi.lindeboom.web2packflow.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class BatchProcessServiceImpl implements BatchProcessService {

    @Autowired
    private BatchService batchService;

    @Autowired
    private ProductGroupRepository productGroupRepository;


    @Override
    public Batch getBatch(OrderItem item) {
        Batch batch =  batchService.findBatch(item.getSubstrateId(),item.getFinishName(),item.getProductGroup());
        ProductGroup productGroup = productGroupRepository.findById(item.getProductGroup().getId()).orElse(null);
        if(batch == null && productGroup != null) {
            batch = batchService.createBatch(item.getSubstrateId(),item.getFinishName(),productGroup);
        }
        else        {
            throw new DataIntegrityViolationException("Product group id "+ item.getProductGroup().getId() +
                    " does not exist in the system!");
        }
        return batch;

    }

}
