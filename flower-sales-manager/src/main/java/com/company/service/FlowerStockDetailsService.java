package com.company.service;

import java.util.List;

import com.company.entity.FlowerStockDetails;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface FlowerStockDetailsService {
	FlowerStockDetails addStockDetails(FlowerStockDetails flowerStockDetails);
	
	List<FlowerStockDetails> ShowStockDetails();
	
	FlowerStockDetails editStockById(int stockId);
	
	void deleteStockById(int stockId);
	

}
