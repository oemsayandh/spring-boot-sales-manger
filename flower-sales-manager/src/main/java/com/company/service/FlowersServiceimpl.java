package com.company.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Flowers;
import com.company.repository.FlowersRepository;
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


}
