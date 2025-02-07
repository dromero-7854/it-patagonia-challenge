package com.itpatagonia.challengue.domain.model.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.itpatagonia.challengue.domain.model.dto.IdDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferRequest {

	private IdDto sender;

	private LocalDateTime executionDate;

	private BigDecimal amount;

	private String debitAccount;

	private String creditAccount;

}
