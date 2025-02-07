package com.itpatagonia.challengue.domain.model;

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
public class Transfer {

	private Long id;

	private Company sender;

	private LocalDateTime executionDate;

	private BigDecimal amount;

	private String debitAccount;

	private String creditAccount;

}
