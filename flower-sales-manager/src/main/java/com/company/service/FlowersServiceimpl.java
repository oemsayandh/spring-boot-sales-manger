package com.company.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Flowers;
import com.company.repository.FlowersRepository;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
@Service
public class FlowersServiceimpl implements FlowerService {
	@Autowired
	private FlowersRepository flowersRepository;

	@Override
	public Flowers insertFlowerDetails(Flowers flowers) {
		return flowersRepository.save(flowers);
		
	}

	@Override
	public List<Flowers> getAllFlowerIdName() {
		return flowersRepository.findAll();
	}

	@Override
	public Flowers getFlowersById(Integer flowerId) {
		
		return flowersRepository.findById(flowerId).orElse(null);
	}

	


}
