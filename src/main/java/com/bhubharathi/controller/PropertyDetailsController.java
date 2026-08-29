package com.bhubharathi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bhubharathi.entity.PropertyDetails;
import com.bhubharathi.service.PropertyDetailsService;

@RestController
@RequestMapping("/api/sale-deed")
public class PropertyDetailsController {

    private final PropertyDetailsService service;

    public PropertyDetailsController(
            PropertyDetailsService service) {

        this.service = service;
    }


    // Add Property
    // POST /api/sale-deed/applications/{applicationId}/property

    @PostMapping("/applications/{applicationId}/property")
    public ResponseEntity<PropertyDetails> addProperty(
            @PathVariable Long applicationId,
            @RequestBody PropertyDetails propertyDetails) {

        PropertyDetails savedProperty =
                service.addProperty(
                        applicationId,
                        propertyDetails);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProperty);
    }


    // Get Property
    // GET /api/sale-deed/properties/{propertyId}

    @GetMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDetails> getProperty(
            @PathVariable Long propertyId) {

        PropertyDetails property =
                service.getProperty(propertyId);

        return ResponseEntity.ok(property);
    }


    // Update Property Boundaries
    // PUT /api/sale-deed/properties/{propertyId}

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDetails> updateProperty(
            @PathVariable Long propertyId,
            @RequestBody PropertyDetails propertyDetails) {

        PropertyDetails updatedProperty =
                service.updateProperty(
                        propertyId,
                        propertyDetails);

        return ResponseEntity.ok(updatedProperty);
    }

}