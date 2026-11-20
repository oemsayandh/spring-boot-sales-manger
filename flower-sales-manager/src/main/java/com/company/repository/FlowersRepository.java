package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Flowers;
/**
 * @author sayandh
 * @date 11/20/2026
 * 
 */
public interface FlowersRepository extends JpaRepository<Flowers, Integer> {

}
