package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.converter.BatchConverter;
import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import nl.novi.lindeboom.web2packflow.payload.response.BatchOverviewResponse;
import nl.novi.lindeboom.web2packflow.payload.response.OrderResponse;
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
    @Autowired
    private BatchConverter batchConverter;

    @Override
    public List<Batch> getBatches() {
        return batchRepository.findAll();
    }



    @Override
    public Batch createBatch(String substrateId, String finishName, ProductGroup productGroup, Integer storeFrontId) {
      return batchRepository.save(new Batch(substrateId, finishName, productGroup,storeFrontId ));
    }

    @Override
    public Batch findBatch(String substrateId, String finishName, ProductGroup productGroup, Integer storeFrontID) {
       return batchRepository.findBySubstrateIdAndFinishNameAndOpenAndProductGroupAndStoreFrontId(substrateId,
               finishName, true, productGroup, storeFrontID);
    }

    @Override
    public Batch getBatch(OrderItem item, Integer storeFrontId) {
        Batch batch = findBatch(item.getSubstrateId(), item.getFinishName(), item.getProductGroup(), storeFrontId);
        ProductGroup productGroup = productGroupRepository.findById(item.getProductGroup().getId()).orElse(null);
        if(batch == null ) {
            if (productGroup != null) {
                batch = createBatch(item.getSubstrateId(), item.getFinishName(), productGroup, storeFrontId);
            } else {
                throw new DataIntegrityViolationException("Product group id " + item.getProductGroup().getId() +
                        " does not exist in the system!");
            }
        }
        return batch;
    }


    @Override
    public List<BatchOverviewResponse> getBatchesOverview() {
        return batchConverter.BatchToBatchOverviewResponse(getBatches());
    }

}
