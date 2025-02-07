package com.itpatagonia.challengue.domain.port;

import java.time.LocalDateTime;
import java.util.List;

import com.itpatagonia.challengue.domain.model.Company;
import com.itpatagonia.challengue.domain.model.Transfer;

public interface TransferPersistencePort {

	Transfer create(Transfer request);

	Transfer getById(Long id);
	
	List<Company> findCompaniesWithTransfersBetweenDates(LocalDateTime startDate, LocalDateTime endDate); 

}
