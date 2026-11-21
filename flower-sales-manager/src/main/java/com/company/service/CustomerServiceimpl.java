package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Customers;
import com.company.repository.CustomersRepository;
/**
 * @author sayandh
 * @date 11/21/2026
 * 
 */
@Service
public class CustomerServiceimpl implements CustomerService {
@Autowired
private CustomersRepository customersRepository;
	
	@Override
	public Customers addCustomerDetails(Customers customers) {
		return customersRepository.save(customers);
	}

	@Override
	public List<Customers> getAllCustomers() {
		return customersRepository.findAll();
	}

	@Override
	public Customers modifyCustomerByID(Integer customerId) {
		return customersRepository.findById(customerId).orElse(null);
	}

	@Override
	public void deleteCustomerByID(Integer customerId) {
		customersRepository.deleteById(customerId);
		
	}

}
