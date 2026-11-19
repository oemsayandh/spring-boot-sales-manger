package com.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
 * @Date :11/19/2026
 * @Author : sayandh
 */
@Entity
@Table(name="flowers")
public class Flowers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="flower_id")
	private Integer flowerId;
	
	@Column(name="flower_name")
	private String flowerName;

	public Flowers() {
	}

	public Integer getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	
	

}
