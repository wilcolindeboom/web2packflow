package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import nl.novi.lindeboom.web2packflow.repository.BatchRepository;
import nl.novi.lindeboom.web2packflow.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BatchServiceImpl implements BatchService{

    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Override
    public List<Batch> getBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Batch createBatch(String substrateId, String finishName, ProductGroup productGroup) {
      return batchRepository.save(new Batch(substrateId, finishName, productGroup));
    }

    @Override
    public Batch findBatch(String substrateId, String finishName, ProductGroup productGroup) {
       return batchRepository.findBySubstrateIdAndFinishNameAndOpenAndProductGroup(substrateId, finishName, true, productGroup );
    }


    @Override
    public Batch getBatch(OrderItem item) {
        Batch batch =  findBatch(item.getSubstrateId(),item.getFinishName(),item.getProductGroup());
        ProductGroup productGroup = productGroupRepository.findById(item.getProductGroup().getId()).orElse(null);
        if(batch == null && productGroup != null) {
            batch = createBatch(item.getSubstrateId(),item.getFinishName(),productGroup);
        }
        else        {
            throw new DataIntegrityViolationException("Product group id "+ item.getProductGroup().getId() +
                    " does not exist in the system!");
        }
        return batch;

    }




    //todo

    @Override
    public List<Batch> getBatchesOverview() {
        return null;
    }

}
