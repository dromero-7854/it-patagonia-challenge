package com.itpatagonia.challengue.domain.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyWithTransfersMadeDto {

	private Long id;

	private LocalDate joiningDate;

	private String cuit;

	private String companyName;

	private List<TransferWithoutSenderDto> transfersMade;
	
}
