package com.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/*
 * @Date : 11/26/2026
 * @Author : sayandh
 */
@Entity
@Table(name="sales_log_details")
public class SalesLogDetails {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_log_id")
    private Integer salesLogId;

    @OneToOne
    @JoinColumn(name = "sale_id", nullable = false, unique = true)
    private SalesDetails salesDetails;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false, unique = true)
    private PayementDetails paymentDetails;

    public SalesLogDetails() {
    	
    }
	public Integer getSalesLogId() {
		return salesLogId;
	}

	public void setSalesLogId(Integer salesLogId) {
		this.salesLogId = salesLogId;
	}

	public SalesDetails getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails(SalesDetails salesDetails) {
		this.salesDetails = salesDetails;
	}

	public PayementDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PayementDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	
	

}
