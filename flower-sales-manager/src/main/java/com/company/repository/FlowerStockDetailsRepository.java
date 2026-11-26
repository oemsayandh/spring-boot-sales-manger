package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.entity.FlowerStockDetails;
import com.company.entity.Flowers;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface FlowerStockDetailsRepository extends JpaRepository<FlowerStockDetails, Integer> {
	
	@Query("SELECT s FROM FlowerStockDetails s WHERE s.flowers = :flower AND s.stock > 0 ORDER BY s.stockDate ASC, s.stockId ASC")
	List<FlowerStockDetails> findAvailableStock(@Param("flower") Flowers flower);

}
