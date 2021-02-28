package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/batches")
public class BatchController {

    @Autowired
    private  BatchService batchservice;

    @GetMapping(value = "")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getBatches() {
        return ResponseEntity.status(200).body(batchservice.getBatchesOverview());
    }
}
