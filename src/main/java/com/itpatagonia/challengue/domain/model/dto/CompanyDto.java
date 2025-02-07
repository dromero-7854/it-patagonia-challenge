package com.itpatagonia.challengue.domain.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {

	private Long id;

	private LocalDate joiningDate;

	private String cuit;

	private String companyName;
	
}
