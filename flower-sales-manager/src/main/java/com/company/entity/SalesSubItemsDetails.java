package com.company.entity;

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
@Table(name="sales_sub_items_details")
public class SalesSubItemsDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sale_item_id")
	private Integer saleItemId;
	
	@ManyToOne
	@JoinColumn(name="sale_id",nullable = false)
	private SalesDetails salesDetails;
	
	@ManyToOne
	@JoinColumn(name="flower_id",nullable = false)
	private Flowers flowers;
	
	@Column(name="quantity")
	private Double quantity;
	
	@Column(name="rate")
	private Double rate;
	
	public SalesSubItemsDetails() {
		
	}

	public Integer getSaleItemId() {
		return saleItemId;
	}

	public void setSaleItemId(Integer saleItemId) {
		this.saleItemId = saleItemId;
	}

	public SalesDetails getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails(SalesDetails salesDetails) {
		this.salesDetails = salesDetails;
	}

	public Flowers getFlowers() {
		return flowers;
	}

	public void setFlowers(Flowers flowers) {
		this.flowers = flowers;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	

}
