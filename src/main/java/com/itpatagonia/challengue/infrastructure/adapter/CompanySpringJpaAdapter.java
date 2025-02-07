package com.itpatagonia.challengue.infrastructure.adapter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itpatagonia.challengue.domain.model.Company;
import com.itpatagonia.challengue.domain.model.constant.CompanyConstant;
import com.itpatagonia.challengue.domain.port.CompanyPersistencePort;
import com.itpatagonia.challengue.infrastructure.adapter.exception.EntityNotFoundException;
import com.itpatagonia.challengue.infrastructure.adapter.mapper.CompanyDboMapper;
import com.itpatagonia.challengue.infrastructure.adapter.mapper.TransferDboMapper;
import com.itpatagonia.challengue.infrastructure.adapter.repository.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompanySpringJpaAdapter implements CompanyPersistencePort {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CompanyDboMapper companyDboMapper;

	@Autowired
	private TransferDboMapper transferDboMapper;

	@Override
	public Company create(Company request) {
		var companyToSave = this.companyDboMapper.toDbo(request);
		var companySaved = this.companyRepository.save(companyToSave);

		return this.companyDboMapper.toDomain(companySaved);
	}

	@Override
	public Company getById(Long id) {
		var optionalCompany = this.companyRepository.findById(id);

		if (optionalCompany.isEmpty()) {
			throw new EntityNotFoundException(String.format(CompanyConstant.COMPANY_NOT_FOUND_MESSAGE_ERROR, id),
					HttpStatus.NOT_FOUND);
		}

		Company company = this.companyDboMapper.toDomain(optionalCompany.get());
		company.setTransfersMade(optionalCompany.get().getTransfersMade().stream()
				.map(this.transferDboMapper::toDomainWihoutSender).collect(Collectors.toList()));
		return company;
	}

	@Override
	public List<Company> getAll() {
		return this.companyRepository.findAll().stream().map(this.companyDboMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		this.companyRepository.deleteById(id);

	}

	@Override
	public Company update(Company request) {
		var companyToUpdate = this.companyDboMapper.toDbo(request);
		var companyUpdated = this.companyRepository.save(companyToUpdate);

		return this.companyDboMapper.toDomain(companyUpdated);
	}

	@Override
	public List<Company> findCompaniesJoinedBetweenDates(LocalDate startDate, LocalDate endDate) {
		return this.companyRepository.findJoinedCompaniesByJoiningDateBetween(startDate, endDate).stream()
				.map(this.companyDboMapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public Company findLastJoined() {
		return this.companyDboMapper.toDomain(this.companyRepository.findLastJoinedCompany());
	}

}
