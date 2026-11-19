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
@Table(name="rate_history_details")
public class RateHistorydDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rate_history_id")
	private Integer rateHistoryId;
	
	@ManyToOne
	@JoinColumn(name="flower_id", nullable = false)
	private Flowers flowers;
	
	@Column(name="changed_date")
	private Date changedDate;
	
	@Column(name="new_rate")
	private Double newRate;	
	
	public RateHistorydDetails() {
		
	}

	public Integer getRateHistoryId() {
		return rateHistoryId;
	}

	public void setRateHistoryId(Integer rateHistoryId) {
		this.rateHistoryId = rateHistoryId;
	}

	public Flowers getFlowers() {
		return flowers;
	}

	public void setFlowers(Flowers flowers) {
		this.flowers = flowers;
	}

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	public Double getNewRate() {
		return newRate;
	}

	public void setNewRate(Double newRate) {
		this.newRate = newRate;
	}

}
