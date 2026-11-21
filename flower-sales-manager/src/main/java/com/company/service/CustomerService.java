package com.company.service;

import java.util.List;

import com.company.entity.Customers;
/**
 * @author sayandh
 * @date 11/21/2026
 * 
 */
public interface CustomerService {
	
	Customers addCustomerDetails(Customers customers);
	
	List<Customers> getAllCustomers();
	
	Customers modifyCustomerByID( Integer customerId);
	
	void deleteCustomerByID( Integer customerId);
	
	

}
