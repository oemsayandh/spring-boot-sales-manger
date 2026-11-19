package com.company.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/*
 * @Date :11/19/2026
 * @Author : sayandh
 */
@Entity
@Table(name="sales_details")
public class SalesDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sale_id")
	private Integer saleId;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id",nullable = false)
	private Customers customers;
	
	@Column(name="bill_no")
	private int billNo;
	
	@Column(name="sale_date")
	private Date saleDate;
	
	@Column(name="sale_total_amount")
	private int saleTotalAmount;
	
	public SalesDetails(){
		
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getSaleTotalAmount() {
		return saleTotalAmount;
	}

	public void setSaleTotalAmount(int saleTotalAmount) {
		this.saleTotalAmount = saleTotalAmount;
	}
}
