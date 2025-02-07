package com.itpatagonia.challengue.application.service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpatagonia.challengue.application.mapper.CompanyDtoMapper;
import com.itpatagonia.challengue.application.mapper.TransferDtoMapper;
import com.itpatagonia.challengue.application.mapper.TransferRequestMapper;
import com.itpatagonia.challengue.application.usecases.TransferService;
import com.itpatagonia.challengue.domain.model.dto.CompanyDto;
import com.itpatagonia.challengue.domain.model.dto.TransferDto;
import com.itpatagonia.challengue.domain.model.dto.TransferWithoutSenderDto;
import com.itpatagonia.challengue.domain.model.dto.request.TransferRequest;
import com.itpatagonia.challengue.domain.port.CompanyPersistencePort;
import com.itpatagonia.challengue.domain.port.TransferPersistencePort;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private CompanyPersistencePort companyPersistencePort;

	@Autowired
	private TransferPersistencePort transferPersistencePort;

	@Autowired
	private TransferRequestMapper transferRequestMapper;

	@Autowired
	private TransferDtoMapper transferDtoMapper;

	@Autowired
	private CompanyDtoMapper companyDtoMapper;

	@Override
	public TransferDto createNew(TransferRequest request) {
		var transferToCreate = this.transferRequestMapper.toDomain(request);
		var transferCreated = this.transferPersistencePort.create(transferToCreate);

		return this.transferDtoMapper.toDto(transferCreated);
	}

	@Override
	public TransferDto getById(Long id) {
		var transfer = this.transferPersistencePort.getById(id);

		return this.transferDtoMapper.toDto(transfer);
	}

	@Override
	public List<TransferWithoutSenderDto> getTransfersByCompanyId(Long companyId) {
		var company = this.companyPersistencePort.getById(companyId);
		return company.getTransfersMade().stream().map(this.transferDtoMapper::toDtoWithoutSender)
				.collect(Collectors.toList());
	}

	@Override
	public List<CompanyDto> getCompaniesWithTransfersLastMonth() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime lastMonthFirstDate = now.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
		LocalDateTime lastMonthLastDate = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		return this.transferPersistencePort
				.findCompaniesWithTransfersBetweenDates(lastMonthFirstDate, lastMonthLastDate).stream()
				.map(this.companyDtoMapper::toDto).collect(Collectors.toList());
	}

}
