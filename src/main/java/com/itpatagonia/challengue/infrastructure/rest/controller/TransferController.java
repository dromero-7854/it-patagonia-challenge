package com.itpatagonia.challengue.infrastructure.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itpatagonia.challengue.application.usecases.TransferService;
import com.itpatagonia.challengue.domain.model.dto.TransferDto;
import com.itpatagonia.challengue.domain.model.dto.request.TransferRequest;

@RestController
@RequestMapping("/transfers")
public class TransferController {

	@Autowired
	private TransferService transferService;

	@PostMapping()
	public ResponseEntity<TransferDto> create(@RequestBody TransferRequest request) {
		TransferDto createdTransfer = this.transferService.createNew(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTransfer.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{id}")
	public TransferDto getById(@PathVariable Long id) {
		return this.transferService.getById(id);
	}

}
