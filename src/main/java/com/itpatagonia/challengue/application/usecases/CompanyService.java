package com.itpatagonia.challengue.application.usecases;

import java.util.List;

import com.itpatagonia.challengue.domain.model.dto.CompanyDto;
import com.itpatagonia.challengue.domain.model.dto.CompanyWithTransfersMadeDto;
import com.itpatagonia.challengue.domain.model.dto.request.CompanyRequest;

public interface CompanyService {
	
	CompanyDto createNew(CompanyRequest request);
	
	CompanyWithTransfersMadeDto getById(Long id);
	
    List<CompanyDto> getAll();
    
    void deleteById(Long id);
    
    CompanyDto update(CompanyRequest request, Long id);
    
    List<CompanyDto> getCompaniesJoinedLastMonth();
    
    CompanyDto getLastJoined();

}
