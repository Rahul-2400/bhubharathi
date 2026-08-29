package com.bhubharathi.service;

import com.bhubharathi.entity.PropertyDetails;

public interface PropertyDetailsService {

    PropertyDetails addProperty(
            Long applicationId,
            PropertyDetails propertyDetails);

    PropertyDetails getProperty(
            Long propertyId);

    PropertyDetails updateProperty(
            Long propertyId,
            PropertyDetails propertyDetails);
}