package com.bhubharathi.service;

import com.bhubharathi.entity.SaleDeedApplication;

public interface SaleDeedApplicationService {

	SaleDeedApplication createApplication(SaleDeedApplication application);

	SaleDeedApplication getApplication(Long applicationId);
}