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
@Table(name="flower_rate_details")
public class FlowerRateDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="flower_rate_id")
	private Integer flowerRateId;
	
	//join class for joining using foreign key
	@ManyToOne
	@JoinColumn(name="flower_id",nullable = false)
	private Flowers flowers;
	
	@Column(name="date_flower_rate")
	private Date dateFlowerRate;
	
	@Column(name="flower_rate")
	private Double flowerRate;

	public FlowerRateDetails() {

	}

	public Integer getFlowerRateId() {
		return flowerRateId;
	}

	public void setFlowerRateId(Integer flowerRateId) {
		this.flowerRateId = flowerRateId;
	}



	public Date getDateFlowerRate() {
		return dateFlowerRate;
	}

	public void setDateFlowerRate(Date dateFlowerRate) {
		this.dateFlowerRate = dateFlowerRate;
	}

	public Double getFlowerRate() {
		return flowerRate;
	}

	public void setFlowerRate(Double flowerRate) {
		this.flowerRate = flowerRate;
	}

	public Flowers getFlowers() {
		return flowers;
	}

	public void setFlowers(Flowers flowers) {
		this.flowers = flowers;
	}

}
