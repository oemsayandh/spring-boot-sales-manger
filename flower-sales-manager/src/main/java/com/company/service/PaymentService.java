package com.company.service;

import com.company.entity.PayementDetails;
import com.company.entity.SalesDetails;

public interface PaymentService {
	SalesDetails getSalesDetails(Integer saleId);
	
	PayementDetails savePayments(PayementDetails payementDetails);
	
	boolean isSaleAlredyPaid(Integer saleId);
	
	void completePayment(PayementDetails payment, Integer saleId);

}
