package com.company.service;

import java.util.List;

import com.company.entity.SalesLogDetails;


public interface SalesLogDetailsService {
	
	public SalesLogDetails saveSalesLog(SalesLogDetails salesLogDetails);

    public List<SalesLogDetails> showAllSalesLogs();

}
