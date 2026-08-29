package com.bhubharathi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhubharathi.entity.SaleDeedApplication;
import com.bhubharathi.service.SaleDeedApplicationService;

@RestController
@RequestMapping("/api/sale-deed")
public class SaleDeedApplicationController {

    private final SaleDeedApplicationService service;

    public SaleDeedApplicationController(
            SaleDeedApplicationService service) {

        this.service = service;
    }


    @PostMapping
    public ResponseEntity<SaleDeedApplication> createApplication(
            @RequestBody SaleDeedApplication application) {

        SaleDeedApplication savedApplication =
                service.createApplication(application);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedApplication);
    }


    @GetMapping("/applications/{applicationId}")
    public ResponseEntity<SaleDeedApplication> getApplication(
            @PathVariable Long applicationId) {

        SaleDeedApplication application =
                service.getApplication(applicationId);

        return ResponseEntity.ok(application);
    }

}