package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.Batch;

import java.util.List;

public interface BatchService {

    List<Batch> getBatches() ;
    Batch createBatch();


}
