package com.itpatagonia.challengue.infrastructure.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.itpatagonia.challengue.domain.model.Company;
import com.itpatagonia.challengue.infrastructure.adapter.entity.CompanyEntity;

@Mapper(componentModel = "spring")
public interface CompanyDboMapper {

	CompanyEntity toDbo(Company domain);
	
	@Mapping(target = "transfersMade", ignore = true)
	Company toDomain(CompanyEntity entity);

}
