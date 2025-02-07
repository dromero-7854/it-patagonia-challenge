package com.itpatagonia.challengue.domain.port;

import java.time.LocalDate;
import java.util.List;

import com.itpatagonia.challengue.domain.model.Company;

public interface CompanyPersistencePort {

	Company create(Company request);

	Company getById(Long id);

	List<Company> getAll();

	void deleteById(Long id);

	Company update(Company request);
	
	List<Company> findCompaniesJoinedBetweenDates(LocalDate startDate, LocalDate endDate);
	
	Company findLastJoined();

}
