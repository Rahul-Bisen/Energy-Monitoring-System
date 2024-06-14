package com.app.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionRequestDto {
	
	
    
    private Long consumer_Id;

   
    private Integer years;
 
    private Integer jan;
   
    private Integer feb;
  
    private Integer mar;
 
    private Integer april;

    private Integer may;
  
    private Integer june;
 
    private Integer july;
   
    private Integer august;
   
    private Integer sept;
   
    private Integer oct;
    
    private Integer nov;
     
    private Integer dec;


}
