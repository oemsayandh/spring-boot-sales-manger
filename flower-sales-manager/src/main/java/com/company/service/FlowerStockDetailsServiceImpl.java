package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.FlowerStockDetails;
import com.company.entity.Flowers;
import com.company.repository.FlowerStockDetailsRepository;
import com.company.repository.FlowersRepository;


@Service
public class FlowerStockDetailsServiceImpl implements FlowerStockDetailsService {
	/**
	 * @author sayandh
	 * @date 11/20/2026
	 * 
	 */
	@Autowired 
	private FlowerStockDetailsRepository flowerStockDetailsRepository;
	@Autowired
    private FlowersRepository flowersRepository;


	@Override
	public FlowerStockDetails addStockDetails(
            FlowerStockDetails flowerStockDetails) {

        Integer flowerId = flowerStockDetails.getFlowers().getFlowerId();

        Flowers flower = flowersRepository.findById(flowerId)
                .orElseThrow(() -> new RuntimeException("Flower not found"));

        flowerStockDetails.setFlowers(flower);

        return flowerStockDetailsRepository.save(flowerStockDetails);
    }

	@Override
	public List<FlowerStockDetails> ShowStockDetails() {
		return flowerStockDetailsRepository.findAll();
	}

	@Override
	public FlowerStockDetails editStockById(int stockId) {
		return flowerStockDetailsRepository.findById(stockId).orElse(null);
	}

	@Override
	public void deleteStockById(int stockId) {
		flowerStockDetailsRepository.deleteById(stockId);
	}









}
