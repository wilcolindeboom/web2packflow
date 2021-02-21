package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
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
    public Batch createBatch(String substrateId, String finishName) {
      return batchRepository.save(new Batch(substrateId, finishName));
    }

    @Override
    public Batch findBatchBySubstrateAndFinish(String substrateId, String finishName) {
       return batchRepository.findBySubstrateIdAndFinishNameAndOpen(substrateId, finishName, true);
    }

    @Override
    public Batch getBatch(OrderItem item) {
        Batch batch =  findBatchBySubstrateAndFinish(item.getSubstrateId(),item.getFinishName());
        if(batch == null) {
            batch = createBatch(item.getSubstrateId(),item.getFinishName());
        }
        return batch;
    }

}
