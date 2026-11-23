package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.entity.SalesDetails;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface SalesDetailsRepository extends JpaRepository<SalesDetails, Integer>{
	
	@Query("SELECT COALESCE(MAX(s.billNo), 1000) + 1 FROM SalesDetails s")
    Integer getNextBillNo();

}
