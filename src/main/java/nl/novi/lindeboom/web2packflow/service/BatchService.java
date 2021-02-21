package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;

import java.util.List;

public interface BatchService {

    List<Batch> getBatches() ;
    Batch createBatch(String substrateId, String finishName, ProductGroup productGroup);
    Batch findBatch(String substrateId, String finishName, ProductGroup productGroup);
    Batch getBatch(OrderItem item);

    List<Batch> getBatchesOverview() ;
}
