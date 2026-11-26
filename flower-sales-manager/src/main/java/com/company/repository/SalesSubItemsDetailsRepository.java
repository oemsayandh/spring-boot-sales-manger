package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.SalesSubItemsDetails;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface SalesSubItemsDetailsRepository extends JpaRepository<SalesSubItemsDetails, Integer> {
	List<SalesSubItemsDetails> findBySalesDetails_SaleId(Integer saleId);

}
