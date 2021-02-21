package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import nl.novi.lindeboom.web2packflow.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BatchServiceImpl implements BatchService{

        @Autowired
        private BatchRepository batchRepository;

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

//    @Override
//    public Batch getBatch(OrderItem item) {
//        Batch batch =  findBatch(item.getSubstrateId(),item.getFinishName(),item.getProductGroup());
//        if(batch == null) {
//            batch = createBatch(item.getSubstrateId(),item.getFinishName(),item.getProductGroup());
//        }
//        return batch;
//    }

    //todo

    @Override
    public List<Batch> getBatchesOverview() {
        return null;
    }

}
