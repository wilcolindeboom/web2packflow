package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.converter.BatchConverter;
import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import nl.novi.lindeboom.web2packflow.payload.response.BatchOverviewResponse;
import nl.novi.lindeboom.web2packflow.repository.BatchRepository;
import nl.novi.lindeboom.web2packflow.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BatchServiceImpl implements BatchService{

    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private ProductGroupRepository productGroupRepository;
    @Autowired
    private BatchConverter batchConverter;


    /** set (or create and set) batch for orderitem
     *  verify productgroup is existing
     */

    @Override
    public Batch getBatch(OrderItem orderItem, Integer storeFrontId) {
        Batch batch = findBatch(orderItem.getSubstrateId(), orderItem.getFinishName(), orderItem.getProductGroup(), storeFrontId);
        ProductGroup productGroup = productGroupRepository.findById(orderItem.getProductGroup().getId()).orElse(null);
        if(batch == null ) {
            if (productGroup != null) {
                batch = createBatch(orderItem.getSubstrateId(), orderItem.getFinishName(), productGroup, storeFrontId, orderItem.getShippingDate());
            } else {
                throw new DataIntegrityViolationException("Product group id " + orderItem.getProductGroup().getId() +
                        " does not exist in the system!");
            }
        }
        setBatchShippingDate(batch, orderItem);
        return batch;
    }


    @Override
    public Batch findBatch(String substrateId, String finishName, ProductGroup productGroup, Integer storeFrontID) {
        return batchRepository.findBySubstrateIdAndFinishNameAndOpenAndProductGroupAndStoreFrontId(substrateId,
                finishName, true, productGroup, storeFrontID);
    }

    @Override
    public Batch createBatch(String substrateId, String finishName, ProductGroup productGroup, Integer storeFrontId, Date shippingDate) {
        return batchRepository.save(new Batch(substrateId, finishName, productGroup,storeFrontId, shippingDate));
    }

    @Override
    public Batch setBatchShippingDate(Batch batch, OrderItem orderItem) {
        if(batch.getShippingDate().compareTo(orderItem.getShippingDate()) > 0) {
            batch.setShippingDate(orderItem.getShippingDate());
        }
        return batch;
    }


    @Override
    public List<BatchOverviewResponse> getBatchesOverview() {
        return batchConverter.BatchToBatchOverviewResponse(getBatches());
    }

    @Override
    public List<Batch> getBatches() {
        return batchRepository.findAll();
    }










}
