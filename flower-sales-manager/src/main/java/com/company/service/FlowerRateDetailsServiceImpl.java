package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.FlowerRateDetails;
import com.company.entity.Flowers;
import com.company.entity.RateHistorydDetails;
import com.company.repository.FlowerRateDetailsRepository;
import com.company.repository.FlowersRepository;
import com.company.repository.RateHistorydDetailsRepository;

import jakarta.transaction.Transactional;

@Service
public class FlowerRateDetailsServiceImpl implements FlowerRateDetailsService {
	@Autowired
	private FlowerRateDetailsRepository flowerRateDetailsRepository;
	@Autowired
	private FlowersRepository flowersRepository;
	@Autowired
	private RateHistorydDetailsRepository rateDetailsRepository;

	@Override
	@Transactional
	public FlowerRateDetails saveCustomerOrder(FlowerRateDetails flowerRateDetails) {
		Integer FlowersId = flowerRateDetails.getFlowers().getFlowerId();
		
		Flowers flowers = flowersRepository.findById(FlowersId).orElse(null);
		flowerRateDetails.setFlowers(flowers);
		
		
		// for transfering rate when changes to rate history/////////
		if (flowerRateDetails.getFlowerRateId() != null) {

	        FlowerRateDetails old = flowerRateDetailsRepository.findById(flowerRateDetails.getFlowerRateId()).orElse(null);
	        if (old != null) {
	            RateHistorydDetails history = new RateHistorydDetails();

	            history.setFlowers(old.getFlowers());
	            history.setChangedDate(old.getDateFlowerRate());
	            history.setNewRate(old.getFlowerRate());

	            rateDetailsRepository.save(history);
	        }
	    }
		////////////////////////////////////////////////////////////////////////////////
		return flowerRateDetailsRepository.save(flowerRateDetails);
	}

	@Override
	public List<FlowerRateDetails> ShowCustomerOrders() {
		
		return flowerRateDetailsRepository.findAll();
	}

	@Override
	public FlowerRateDetails updateCustomerOrderDateById(Integer flowerRateId) {
		
		return flowerRateDetailsRepository.findById(flowerRateId).orElse(null);
	}

	@Override
	public void deleteCustomerOrderDateById(Integer flowerRateId) {
		flowerRateDetailsRepository.deleteById(flowerRateId);
		
	}

}
