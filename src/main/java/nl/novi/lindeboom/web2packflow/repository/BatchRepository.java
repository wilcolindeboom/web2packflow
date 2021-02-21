package nl.novi.lindeboom.web2packflow.repository;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import nl.novi.lindeboom.web2packflow.domain.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, Long>{

    Batch findBySubstrateIdAndFinishNameAndOpen(String substrateId, String finishName,boolean closed);
    Batch findBySubstrateIdAndFinishNameAndOpenAndProductGroup(String substrateId, String finishName, boolean closed, ProductGroup productGroup);

}
