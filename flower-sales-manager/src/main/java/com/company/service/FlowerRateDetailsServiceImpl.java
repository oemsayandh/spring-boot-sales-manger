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
/**
 * @author sayandh
 * @date 11/22/2026
 * 
 */
@Service
public class FlowerRateDetailsServiceImpl implements FlowerRateDetailsService {
	@Autowired
	private FlowerRateDetailsRepository flowerRateDetailsRepository;
	@Autowired
	private FlowersRepository flowersRepository;
	@Autowired
	private RateHistorydDetailsRepository ratehistoryDetailsRepository;

	@Override
	@Transactional
	public FlowerRateDetails saveCustomerOrder(FlowerRateDetails details) {

	    Flowers flowers = flowersRepository.findById(
	            details.getFlowers().getFlowerId()).orElse(null);

	    details.setFlowers(flowers);

	    if (details.getFlowerRateId() != null) {

	        FlowerRateDetails old = flowerRateDetailsRepository
	                .findById(details.getFlowerRateId()).orElse(null);

	        if (old != null && !old.getFlowerRate().equals(details.getFlowerRate())) {

	            RateHistorydDetails history = new RateHistorydDetails();
	            history.setFlowers(old.getFlowers());
	            history.setChangedDate(new java.sql.Date(System.currentTimeMillis()));
	            history.setNewRate(old.getFlowerRate());

	            ratehistoryDetailsRepository.save(history);
	        }
	    }

	    return flowerRateDetailsRepository.save(details);
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

	@Override
	public List<FlowerRateDetails> getRatesByFlowerId(Integer flowerId) {
		
		return flowerRateDetailsRepository.findByFlowers_FlowerIdOrderByDateFlowerRateDesc(flowerId);
	}

}
