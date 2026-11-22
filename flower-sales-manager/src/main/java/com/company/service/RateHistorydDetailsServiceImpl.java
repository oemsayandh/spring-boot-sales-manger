package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.RateHistorydDetails;
import com.company.repository.RateHistorydDetailsRepository;

@Service
public class RateHistorydDetailsServiceImpl implements RateHistorydDetailsService{
	@Autowired
	private RateHistorydDetailsRepository rateDetailsRepository;

	@Override
	public List<RateHistorydDetails> showAllRateHistory() {
		return rateDetailsRepository.findAll();
		
	}

}
