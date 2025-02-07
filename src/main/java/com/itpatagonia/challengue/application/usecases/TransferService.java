package com.itpatagonia.challengue.application.usecases;

import java.util.List;

import com.itpatagonia.challengue.domain.model.dto.CompanyDto;
import com.itpatagonia.challengue.domain.model.dto.TransferDto;
import com.itpatagonia.challengue.domain.model.dto.TransferWithoutSenderDto;
import com.itpatagonia.challengue.domain.model.dto.request.TransferRequest;

public interface TransferService {
	
	TransferDto createNew(TransferRequest request);
	
	TransferDto getById(Long id);
	
	List<TransferWithoutSenderDto> getTransfersByCompanyId(Long companyId);
	
	List<CompanyDto> getCompaniesWithTransfersLastMonth();

}
