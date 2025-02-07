package com.itpatagonia.challengue.infrastructure.adapter.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itpatagonia.challengue.infrastructure.adapter.entity.CompanyEntity;
import com.itpatagonia.challengue.infrastructure.adapter.entity.TransferEntity;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

	@Query("SELECT DISTINCT c FROM TransferEntity t INNER JOIN CompanyEntity c ON t.sender.id = c.id WHERE t.executionDate BETWEEN :startDate AND :endDate")
	List<CompanyEntity> findCompaniesWithTransfersBetweenDates(@Param("startDate") LocalDateTime startDate,
			@Param("endDate") LocalDateTime endDate);

}
