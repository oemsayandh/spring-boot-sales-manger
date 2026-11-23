package com.company.service;



import java.util.List;

import com.company.entity.Flowers;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface FlowerService {
	
	Flowers insertFlowerDetails(Flowers flowers);

	List<Flowers> getAllFlowerIdName();
	
	Flowers getFlowersById(Integer flowerId);
	

}
