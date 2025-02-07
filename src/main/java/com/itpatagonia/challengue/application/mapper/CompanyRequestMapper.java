package com.itpatagonia.challengue.application.mapper;

import org.mapstruct.Mapper;

import com.itpatagonia.challengue.domain.model.Company;
import com.itpatagonia.challengue.domain.model.dto.request.CompanyRequest;

@Mapper(componentModel = "spring")
public interface CompanyRequestMapper {
	
	Company toDomain(CompanyRequest request);

}
