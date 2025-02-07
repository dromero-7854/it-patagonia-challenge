package com.itpatagonia.challengue.infrastructure.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itpatagonia.challengue.application.usecases.CompanyService;
import com.itpatagonia.challengue.application.usecases.TransferService;
import com.itpatagonia.challengue.domain.model.dto.CompanyDto;
import com.itpatagonia.challengue.domain.model.dto.CompanyWithTransfersMadeDto;
import com.itpatagonia.challengue.domain.model.dto.TransferWithoutSenderDto;
import com.itpatagonia.challengue.domain.model.dto.request.CompanyRequest;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private TransferService transferService;

	@GetMapping("")
	public List<CompanyDto> getAll() {
		return this.companyService.getAll();
	}

	@GetMapping("/{id}")
	public CompanyWithTransfersMadeDto getById(@PathVariable Long id) {
		return this.companyService.getById(id);
	}

	@PostMapping()
	public ResponseEntity<CompanyDto> create(@RequestBody CompanyRequest request) {
		CompanyDto createdCompany = this.companyService.createNew(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdCompany.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public CompanyDto edit(@RequestBody CompanyRequest request, @PathVariable Long id) {
		return this.companyService.update(request, id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		this.companyService.deleteById(id);
	}

	@GetMapping("/{id}/transfers")
	public List<TransferWithoutSenderDto> getTransfers(@PathVariable Long id) {
		return this.transferService.getTransfersByCompanyId(id);
	}

	@GetMapping("/with-transfers-last-month")
	List<CompanyDto> getWithTransfersLastMonth() {
		return this.transferService.getCompaniesWithTransfersLastMonth();
	}

	@GetMapping("/joined-last-month")
	List<CompanyDto> getJoinedLastMonth() {
		return this.companyService.getCompaniesJoinedLastMonth();
	}
	
	@GetMapping("/last-joined")
	CompanyDto getLastJoined() {
		return this.companyService.getLastJoined();
	}
	
}
