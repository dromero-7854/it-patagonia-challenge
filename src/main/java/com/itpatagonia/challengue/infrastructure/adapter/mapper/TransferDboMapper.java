package com.itpatagonia.challengue.infrastructure.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.itpatagonia.challengue.domain.model.Transfer;
import com.itpatagonia.challengue.infrastructure.adapter.entity.TransferEntity;

@Mapper(componentModel = "spring")
public interface TransferDboMapper {

	TransferEntity toDbo(Transfer domain);

	@Mapping(target = "sender.transfersMade", ignore = true)
	Transfer toDomain(TransferEntity entity);
	
	@Mapping(target = "sender", ignore = true)
	Transfer toDomainWihoutSender(TransferEntity entity);

}
