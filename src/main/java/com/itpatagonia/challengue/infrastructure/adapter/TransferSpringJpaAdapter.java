package com.itpatagonia.challengue.infrastructure.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itpatagonia.challengue.domain.model.Company;
import com.itpatagonia.challengue.domain.model.Transfer;
import com.itpatagonia.challengue.domain.model.constant.TransferConstant;
import com.itpatagonia.challengue.domain.port.TransferPersistencePort;
import com.itpatagonia.challengue.infrastructure.adapter.exception.EntityNotFoundException;
import com.itpatagonia.challengue.infrastructure.adapter.mapper.CompanyDboMapper;
import com.itpatagonia.challengue.infrastructure.adapter.mapper.TransferDboMapper;
import com.itpatagonia.challengue.infrastructure.adapter.repository.TransferRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransferSpringJpaAdapter implements TransferPersistencePort {

	@Autowired
	private TransferRepository transferRepository;

	@Autowired
	private TransferDboMapper transferDboMapper;

	@Autowired
	private CompanyDboMapper companyDboMapper;

	@Override
	public Transfer create(Transfer request) {
		var transferToSave = this.transferDboMapper.toDbo(request);
		var transferSaved = this.transferRepository.save(transferToSave);

		return this.transferDboMapper.toDomain(transferSaved);
	}

	@Override
	public Transfer getById(Long id) {
		var optionalTransfer = this.transferRepository.findById(id);

		if (optionalTransfer.isEmpty()) {
			throw new EntityNotFoundException(String.format(TransferConstant.TRANSFER_NOT_FOUND_MESSAGE_ERROR, id),
					HttpStatus.NOT_FOUND);
		}

		return this.transferDboMapper.toDomain(optionalTransfer.get());
	}

	@Override
	public List<Company> findCompaniesWithTransfersBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
		return this.transferRepository.findCompaniesWithTransfersBetweenDates(startDate, endDate).stream()
				.map(this.companyDboMapper::toDomain).collect(Collectors.toList());
	}

}
