package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.FlowerRateDetails;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface FlowerRateDetailsRepository extends JpaRepository<FlowerRateDetails, Integer> {
	List<FlowerRateDetails> findByFlowers_FlowerIdOrderByDateFlowerRateDesc(
			Integer flowerId );

}
