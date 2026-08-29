package com.bhubharathi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhubharathi.entity.PropertyDetails;

public interface PropertyDetailsRepository
        extends JpaRepository<PropertyDetails, Long> {

}