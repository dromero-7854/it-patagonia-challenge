package com.itpatagonia.challengue.application.mapper;

import org.mapstruct.Mapper;

import com.itpatagonia.challengue.domain.model.Transfer;
import com.itpatagonia.challengue.domain.model.dto.TransferDto;
import com.itpatagonia.challengue.domain.model.dto.TransferWithoutSenderDto;

@Mapper(componentModel = "spring")
public interface TransferDtoMapper {

	TransferDto toDto(Transfer domain);
	
	TransferWithoutSenderDto toDtoWithoutSender(Transfer domain);

}
