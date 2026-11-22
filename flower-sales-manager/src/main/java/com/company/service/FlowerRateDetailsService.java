package com.company.service;

import java.util.List;

import com.company.entity.FlowerRateDetails;

public interface FlowerRateDetailsService {
	FlowerRateDetails saveCustomerOrder(FlowerRateDetails flowerRateDetails);
	
	List<FlowerRateDetails> ShowCustomerOrders();
	
	FlowerRateDetails updateCustomerOrderDateById(Integer flowerRateId);
	
	void deleteCustomerOrderDateById(Integer flowerRateId);
	
	
	
	
	
	
	
}
