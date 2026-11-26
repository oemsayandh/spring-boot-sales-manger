package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.PayementDetails;
import com.company.entity.SalesDetails;
import com.company.entity.SalesLogDetails;
import com.company.entity.SalesSubItemsDetails;
import com.company.repository.PayementDetailsRepository;
import com.company.repository.SalesDetailsRepository;
import com.company.repository.SalesSubItemsDetailsRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PayementDetailsRepository payementDetailsRepository;
	@Autowired
	private SalesDetailsRepository salesDetailsRepository;
	
	@Autowired
	private SalesSubItemsDetailsRepository itemsRepository;

	@Autowired
	private FlowerStockDetailsService stockService;
	
	@Autowired
	private SalesLogDetailsService salesLogService;

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

	@Override
	@Transactional
	public void completePayment(PayementDetails payment, Integer saleId) {

	    SalesDetails sale = getSalesDetails(saleId);

	    List<SalesSubItemsDetails> items =
	            itemsRepository.findBySalesDetails_SaleId(saleId);

	    for (SalesSubItemsDetails item : items)
	        stockService.reduceStock(
	            item.getFlowers().getFlowerId(), item.getQuantity());

	    payment.setSalesDetails(sale);
	    payment.setPaymentAmount(sale.getSaleTotalAmount());

	    PayementDetails saved = savePayments(payment);

	    SalesLogDetails log = new SalesLogDetails();
	    log.setSalesDetails(sale);
	    log.setPaymentDetails(saved);

	    salesLogService.saveSalesLog(log);
	}

}
