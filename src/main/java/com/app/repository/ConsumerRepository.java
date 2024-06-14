package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Consumer;
import com.app.entity.Consumption;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

	Optional<Consumer> findByEmailAndPassword(String email, String password);

	Optional <Consumer> findByUserUserId(Long userId);

//	Consumer findConsumerByUserId(Long userId);

//	   @Query("SELECT c FROM Consumption c WHERE c.consumer.id = :id")
//	    List<Consumption> findByConsumerId(@Param("id") Long id);

//	    @Query("Select c from Consumer where c.user_id : userId")
//		Consumer findConsumerByUserid(Long userId);
//	    
//	    @Query("SELECT c FROM Consumer c WHERE c.user_id = :userId")
//	    Consumer findConsumerByUserId(@Param("userId") Long userId);

	

}
