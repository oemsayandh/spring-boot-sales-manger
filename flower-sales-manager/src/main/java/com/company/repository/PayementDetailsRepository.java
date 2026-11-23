package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.PayementDetails;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface PayementDetailsRepository extends JpaRepository<PayementDetails, Integer>{
	boolean existsBySalesDetails_SaleId(Integer saleId);

}
