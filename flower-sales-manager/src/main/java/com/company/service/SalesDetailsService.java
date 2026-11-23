package com.company.service;

import java.sql.Date;
import java.util.List;

import com.company.entity.Customers;
import com.company.entity.SalesDetails;
import com.company.entity.SalesSubItemsDetails;

public interface SalesDetailsService {
	public Integer getBillno();
	
	SalesDetails saveDetails(Customers customers,Date saleDate,List<SalesSubItemsDetails> items );
	
}
