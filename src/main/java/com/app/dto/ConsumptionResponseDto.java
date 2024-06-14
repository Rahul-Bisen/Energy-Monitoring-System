package com.app.dto;

import java.util.ArrayList;
import java.util.List;



import com.app.entity.Consumption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumptionResponseDto {
	
	
	    private Long consumption_id;

	    
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
	    
	    private Long consumer_id;
	    
	    public static List<ConsumptionResponseDto> consumptionList(List<Consumption> consumptionList){
	    	
	    	List<ConsumptionResponseDto> list = new ArrayList<>();
	    	
	    	for ( Consumption c : consumptionList) {
	    		
	    		ConsumptionResponseDto cdto = new ConsumptionResponseDto();
	    		cdto.setConsumption_id(c.getConsumption_id());
	    		cdto.setYears(c.getYears());
	    		cdto.setJan(c.getJan());
	    		cdto.setFeb(c.getFeb());
	    		cdto.setMar(c.getMar());
	    		cdto.setApril(c.getApril());
	    		cdto.setMay(c.getMay());
	    		cdto.setJune(c.getJune());
	    		cdto.setJuly(c.getJuly());
	    		cdto.setAugust(c.getAugust());
	    		cdto.setSept(c.getSept());
	    		cdto.setOct(c.getOct());
	    		cdto.setNov(c.getNov());
	    		cdto.setDec(c.getDec());
	    	
	    }
	    	
	    	return list;
	    
}
	
	

}
