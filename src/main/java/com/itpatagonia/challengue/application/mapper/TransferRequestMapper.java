package com.itpatagonia.challengue.application.mapper;

import org.mapstruct.Mapper;

import com.itpatagonia.challengue.domain.model.Transfer;
import com.itpatagonia.challengue.domain.model.dto.request.TransferRequest;

@Mapper(componentModel = "spring")
public interface TransferRequestMapper {
	
	Transfer toDomain(TransferRequest request);

}
