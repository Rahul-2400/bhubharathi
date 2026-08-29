package com.bhubharathi.service.impl;

import org.springframework.stereotype.Service;

import com.bhubharathi.entity.PropertyDetails;
import com.bhubharathi.entity.SaleDeedApplication;
import com.bhubharathi.repository.PropertyDetailsRepository;
import com.bhubharathi.repository.SaleDeedApplicationRepository;
import com.bhubharathi.service.PropertyDetailsService;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {

	private final PropertyDetailsRepository propertyRepository;

	private final SaleDeedApplicationRepository applicationRepository;

	public PropertyDetailsServiceImpl(PropertyDetailsRepository propertyRepository,
			SaleDeedApplicationRepository applicationRepository) {

		this.propertyRepository = propertyRepository;

		this.applicationRepository = applicationRepository;
	}

	// ------------------------------------------
	// Add Property
	// ------------------------------------------

	@Override
	public PropertyDetails addProperty(Long applicationId, PropertyDetails propertyDetails) {

		SaleDeedApplication application = applicationRepository.findById(applicationId)
				.orElseThrow(() -> new RuntimeException("Application not found: " + applicationId));

		// Link property with application

		propertyDetails.setApplication(application);

		return propertyRepository.save(propertyDetails);
	}

	// ------------------------------------------
	// Get Property
	// ------------------------------------------

	@Override
	public PropertyDetails getProperty(Long propertyId) {

		return propertyRepository.findById(propertyId)
				.orElseThrow(() -> new RuntimeException("Property not found: " + propertyId));
	}

	// ------------------------------------------
	// Update Property
	// ------------------------------------------

	@Override
	public PropertyDetails updateProperty(Long propertyId, PropertyDetails propertyDetails) {

		PropertyDetails existingProperty = propertyRepository.findById(propertyId)
				.orElseThrow(() -> new RuntimeException("Property not found: " + propertyId));

		existingProperty.setPpbNo(propertyDetails.getPpbNo());

		existingProperty.setDistrict(propertyDetails.getDistrict());

		existingProperty.setMandal(propertyDetails.getMandal());

		existingProperty.setVillage(propertyDetails.getVillage());

		existingProperty.setKhataNo(propertyDetails.getKhataNo());

		existingProperty.setPattadarName(propertyDetails.getPattadarName());

		existingProperty.setSurveyNo(propertyDetails.getSurveyNo());

		existingProperty.setSubDivisionNo(propertyDetails.getSubDivisionNo());

		existingProperty.setOwnerExtent(propertyDetails.getOwnerExtent());

		existingProperty.setTransactedExtent(propertyDetails.getTransactedExtent());

		existingProperty.setConsiderationValue(propertyDetails.getConsiderationValue());

		existingProperty.setMarketValue(propertyDetails.getMarketValue());

		existingProperty.setNorthBoundary(propertyDetails.getNorthBoundary());

		existingProperty.setSouthBoundary(propertyDetails.getSouthBoundary());

		existingProperty.setEastBoundary(propertyDetails.getEastBoundary());

		existingProperty.setWestBoundary(propertyDetails.getWestBoundary());

		return propertyRepository.save(existingProperty);
	}
}