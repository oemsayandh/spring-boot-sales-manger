package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.SalesLogDetails;
import com.company.repository.SalesLogDetailsRepository;

@Service
public class SalesLogDetailsServiceImpl implements SalesLogDetailsService{
	
	@Autowired
	private SalesLogDetailsRepository salesLogDetailsRepository;

	
	@Override
	public SalesLogDetails saveSalesLog(SalesLogDetails salesLogDetails) {
		return salesLogDetailsRepository.save(salesLogDetails);
	}

	@Override
	public List<SalesLogDetails> showAllSalesLogs() {
		return salesLogDetailsRepository.findAll();
	}

}
