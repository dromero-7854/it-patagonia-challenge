package com.itpatagonia.challengue.application.mapper;

import org.mapstruct.Mapper;

import com.itpatagonia.challengue.domain.model.Company;
import com.itpatagonia.challengue.domain.model.dto.CompanyDto;
import com.itpatagonia.challengue.domain.model.dto.CompanyWithTransfersMadeDto;

@Mapper(componentModel = "spring")
public interface CompanyDtoMapper {

	CompanyWithTransfersMadeDto toDtoWithTransfersMade(Company domain);
	
	CompanyDto toDto(Company domain);

}
