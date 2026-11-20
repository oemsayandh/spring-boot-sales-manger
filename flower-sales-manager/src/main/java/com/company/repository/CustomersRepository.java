package com.company.repository;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer>{

}
