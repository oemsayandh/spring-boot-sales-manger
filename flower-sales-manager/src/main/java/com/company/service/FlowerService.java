package com.company.service;



import java.util.List;

import com.company.entity.Flowers;

public interface FlowerService {
	
	Flowers insertFlowerDetails(Flowers flowers);

	List<Flowers> getAllFlowerIdName();
	

}
