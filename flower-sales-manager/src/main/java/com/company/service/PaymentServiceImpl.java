package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.PayementDetails;
import com.company.entity.SalesDetails;
import com.company.repository.PayementDetailsRepository;
import com.company.repository.SalesDetailsRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PayementDetailsRepository payementDetailsRepository;
	@Autowired
	private SalesDetailsRepository salesDetailsRepository;

	@Override
	public SalesDetails getSalesDetails(Integer saleId) {
		return salesDetailsRepository.findById(saleId).orElse(null);
	}

	@Override
	public PayementDetails savePayments(PayementDetails payementDetails) {
		//////////////////////////////////////look it up
		Integer saleId =
				payementDetails.getSalesDetails().getSaleId();

        if (isSaleAlredyPaid(saleId)) {

            throw new IllegalStateException(
                    "This sale has already been paid!");

        }
		return payementDetailsRepository.save(payementDetails);
	}
/////////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean isSaleAlredyPaid(Integer saleId) {
		
		return payementDetailsRepository.existsBySalesDetails_SaleId(saleId);
	}

}
