package com.company.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Customers;
import com.company.entity.SalesDetails;
import com.company.entity.SalesSubItemsDetails;
import com.company.repository.SalesDetailsRepository;
import com.company.repository.SalesSubItemsDetailsRepository;

import jakarta.transaction.Transactional;

@Service
public class SalesDetailsServiceImpl implements SalesDetailsService{
	@Autowired 
	private SalesDetailsRepository salesDetailsRepository;
	
	@Autowired
	private SalesSubItemsDetailsRepository salesSubItemsDetailsRepository;
	

	@Override
	public Integer getBillno() {
		
		return salesDetailsRepository.getNextBillNo();
	}

	@Override
	@Transactional
	public SalesDetails saveDetails(Customers customers, Date saleDate, List<SalesSubItemsDetails> items) {
		////////////////////////////////for connecting AND makeing tootal bussiness logic///////
		SalesDetails salesDetails = new SalesDetails();
		
		salesDetails.setCustomers(customers);
		salesDetails.setSaleDate(saleDate);
		salesDetails.setBillNo(getBillno());
		int saleTotalAmount = (int) items.stream().mapToDouble(item -> item.getQuantity() * item.getRate()).sum();
		
		salesDetails.setSaleTotalAmount(saleTotalAmount);
		
		SalesDetails savedSales = salesDetailsRepository.save(salesDetails);
		
		items.forEach(item -> item.setSalesDetails(savedSales));
		
		salesSubItemsDetailsRepository.saveAll(items);
		

		return savedSales;
		///////////////////////////////////////////////////////////////////////////////////////////////
	}

}
