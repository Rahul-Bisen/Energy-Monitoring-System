package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Consumption;

public interface BillingRepository extends  JpaRepository<Consumption, Long>{

	
	//Consumption findByConsumer_Id(Long consumerId);
	 @Query("SELECT c FROM Consumption c WHERE c.consumer.id = :consumerId")
	    List<Consumption> findByConsumerId(@Param("consumerId") Long consumerId);

	
	
	@Query("SELECT c FROM Consumption c WHERE c.consumer.id = :consumerId")
    List<Consumption> findConsumptionsByConsumerId(@Param("consumerId") Long consumerId);

}
