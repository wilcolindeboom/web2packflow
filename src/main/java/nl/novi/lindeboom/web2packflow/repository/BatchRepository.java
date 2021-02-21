package nl.novi.lindeboom.web2packflow.repository;

import nl.novi.lindeboom.web2packflow.domain.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, Long>{

    Batch findBySubstrateIdAndFinishNameAndOpen(String substrateId, String finishName,boolean closed);
}
