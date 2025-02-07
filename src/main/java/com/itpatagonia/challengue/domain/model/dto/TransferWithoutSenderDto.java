package com.itpatagonia.challengue.domain.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferWithoutSenderDto {

	private Long id;

	private LocalDateTime executionDate;

	private BigDecimal amount;

	private String debitAccount;

	private String creditAccount;

}
