package nl.novi.lindeboom.web2packflow.converter;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.payload.response.BatchOverviewResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BatchConverter {



    public BatchOverviewResponse BatchToBatchResponse(Batch batch) {
        BatchOverviewResponse newBatchOverviewResponse = new BatchOverviewResponse();
        newBatchOverviewResponse.setId(batch.getId());
        newBatchOverviewResponse.setFinishName(batch.getFinishName());
        newBatchOverviewResponse.setOpen(batch.isOpen());
        newBatchOverviewResponse.setSubstrateId(batch.getSubstrateId());
        newBatchOverviewResponse.setFinishName(batch.getFinishName());
        newBatchOverviewResponse.setShippingDate(batch.getShippingDate());
        newBatchOverviewResponse.setOrderItems(batch.getOrderItems());
        return newBatchOverviewResponse;
    }

    public List<BatchOverviewResponse> BatchToBatchOverviewResponse(List<Batch> batches) {
        return batches.stream().map(batch -> BatchToBatchResponse(batch)).collect(Collectors.toList());
    }

}
