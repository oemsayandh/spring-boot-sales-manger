package com.company.service;

import java.util.List;

import com.company.entity.FlowerRateDetails;
/**
 * @author sayandh
 * @date 11/22/2026
 * 
 */
public interface FlowerRateDetailsService {
	FlowerRateDetails saveCustomerOrder(FlowerRateDetails flowerRateDetails);
	
	List<FlowerRateDetails> ShowCustomerOrders();
	
	FlowerRateDetails updateCustomerOrderDateById(Integer flowerRateId);
	
	void deleteCustomerOrderDateById(Integer flowerRateId);
	
	List<FlowerRateDetails> getRatesByFlowerId(Integer flowerId);
	
	
	
	
	
}
