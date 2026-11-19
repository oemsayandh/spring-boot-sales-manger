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
@Table(name="payement_details")
public class PayementDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Integer paymentId;
	
	@ManyToOne
	@JoinColumn(name="sale_id",nullable = false)
	private SalesDetails salesDetails;
	
	@Column(name="payment_date")
	private Date paymentDate;
	
	@Column(name="payement_mode")
	private String payementMode;
	
	public PayementDetails() {
		
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public SalesDetails getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails(SalesDetails salesDetails) {
		this.salesDetails = salesDetails;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPayementMode() {
		return payementMode;
	}

	public void setPayementMode(String payementMode) {
		this.payementMode = payementMode;
	}
	

}
