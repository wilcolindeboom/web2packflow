package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import nl.novi.lindeboom.web2packflow.payload.response.BatchOverviewResponse;

import java.sql.Date;
import java.util.List;

public interface BatchService {

    List<Batch> getBatches() ;
    Batch createBatch(String substrateId, String finishName, ProductGroup productGroup, Integer storeFrontId, Date shippingDate);
    Batch findBatch(String substrateId, String finishName, ProductGroup productGroup, Integer storeFrontID);
    Batch getBatch(OrderItem item, Integer storeFrontId);
    List<BatchOverviewResponse> getBatchesOverview();
    Batch setBatchShippingDate(Batch batch, OrderItem orderItem);
}
