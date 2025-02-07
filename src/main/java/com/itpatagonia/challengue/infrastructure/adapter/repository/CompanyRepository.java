package com.itpatagonia.challengue.infrastructure.adapter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itpatagonia.challengue.infrastructure.adapter.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

	@Query("FROM CompanyEntity c WHERE c.joiningDate BETWEEN :startDate AND :endDate")
	List<CompanyEntity> findJoinedCompaniesByJoiningDateBetween(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

	@Query("FROM CompanyEntity c ORDER BY c.joiningDate DESC")
	List<CompanyEntity> findJoinedCompaniesOrderByJoiningDateDesc(Pageable pageable);

	default CompanyEntity findLastJoinedCompany() {
		return findJoinedCompaniesOrderByJoiningDateDesc(PageRequest.of(0, 1)).stream().findFirst().orElse(null);
	}

}
