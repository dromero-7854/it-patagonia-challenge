package com.itpatagonia.challengue.application.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpatagonia.challengue.application.mapper.CompanyDtoMapper;
import com.itpatagonia.challengue.application.mapper.CompanyRequestMapper;
import com.itpatagonia.challengue.application.usecases.CompanyService;
import com.itpatagonia.challengue.domain.model.dto.CompanyDto;
import com.itpatagonia.challengue.domain.model.dto.CompanyWithTransfersMadeDto;
import com.itpatagonia.challengue.domain.model.dto.request.CompanyRequest;
import com.itpatagonia.challengue.domain.port.CompanyPersistencePort;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyPersistencePort companyPersistencePort;

	@Autowired
	private CompanyRequestMapper companyRequestMapper;

	@Autowired
	private CompanyDtoMapper companyDtoMapper;

	@Override
	public CompanyDto createNew(CompanyRequest request) {
		var companyToCreate = this.companyRequestMapper.toDomain(request);
		companyToCreate.setJoiningDate(LocalDate.now());
		var companyCreated = this.companyPersistencePort.create(companyToCreate);

		return this.companyDtoMapper.toDto(companyCreated);
	}

	@Override
	public CompanyWithTransfersMadeDto getById(Long id) {
		var company = this.companyPersistencePort.getById(id);

		return this.companyDtoMapper.toDtoWithTransfersMade(company);
	}

	@Override
	public List<CompanyDto> getAll() {
		var companies = this.companyPersistencePort.getAll();
		return companies.stream().map(this.companyDtoMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		this.companyPersistencePort.deleteById(id);
	}

	@Override
	public CompanyDto update(CompanyRequest request, Long id) {
		var companyToUpdate = this.companyPersistencePort.getById(id);

		companyToUpdate.setCuit(request.getCuit());
		companyToUpdate.setCompanyName(request.getCompanyName());

		var companyUpdated = this.companyPersistencePort.update(companyToUpdate);

		return this.companyDtoMapper.toDto(companyUpdated);
	}

	@Override
	public List<CompanyDto> getCompaniesJoinedLastMonth() {
		LocalDate now = LocalDate.now();
		LocalDate lastMonthFirstDate = now.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastMonthLastDate = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		return this.companyPersistencePort.findCompaniesJoinedBetweenDates(lastMonthFirstDate, lastMonthLastDate)
				.stream().map(this.companyDtoMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public CompanyDto getLastJoined() {
		return this.companyDtoMapper.toDto(this.companyPersistencePort.findLastJoined());
	}

}
