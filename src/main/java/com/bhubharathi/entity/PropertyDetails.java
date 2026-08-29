package com.bhubharathi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "property_details")
@Data
public class PropertyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ppbNo;

    private String district;

    private String mandal;

    private String village;

    private String khataNo;

    private String pattadarName;

    private String surveyNo;

    private String subDivisionNo;

    private BigDecimal ownerExtent;

    private BigDecimal transactedExtent;

    private BigDecimal considerationValue;

    private BigDecimal marketValue;
    
    private String northBoundary;

    private String southBoundary;

    private String eastBoundary;

    private String westBoundary;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    private SaleDeedApplication application;
}