package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;

import java.util.List;

public interface BatchService {

    List<Batch> getBatches() ;
    Batch createBatch(String substrateId, String finishName);
    Batch findBatchBySubstrateAndFinish(String substrateId, String finishName);
    Batch getBatch(OrderItem item);

}
