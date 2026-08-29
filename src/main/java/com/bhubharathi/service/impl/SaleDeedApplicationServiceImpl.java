package com.bhubharathi.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhubharathi.entity.SaleDeedApplication;
import com.bhubharathi.repository.SaleDeedApplicationRepository;
import com.bhubharathi.service.SaleDeedApplicationService;

@Service
public class SaleDeedApplicationServiceImpl implements SaleDeedApplicationService {

	private final SaleDeedApplicationRepository repository;

	public SaleDeedApplicationServiceImpl(SaleDeedApplicationRepository repository) {

		this.repository = repository;
	}

	@Override
	@Transactional
	public SaleDeedApplication createApplication(SaleDeedApplication application) {

		// Set initial status
		application.setStatus("DRAFT");

		// Set timestamps
		LocalDateTime now = LocalDateTime.now();

		application.setCreatedAt(now);
		application.setUpdatedAt(now);

		// First save - PostgreSQL generates the ID
		SaleDeedApplication savedApplication = repository.save(application);

		// Generate application number using year + database ID
		int year = LocalDate.now().getYear() % 100;

		String applicationNo = String.format("%02d%08d", year, savedApplication.getId());

		savedApplication.setApplicationNo(applicationNo);

		// Save application number
		return repository.save(savedApplication);
	}

	@Override
	@Transactional(readOnly = true)
	public SaleDeedApplication getApplication(Long applicationId) {

		return repository.findById(applicationId)
				.orElseThrow(() -> new RuntimeException("Application not found: " + applicationId));
	}
}