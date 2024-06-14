package com.app.dto;

import com.app.entity.Consumer;
import com.app.entity.Consumption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

public class ConsumerDetailsDto extends Consumption {
	
	private Long consumer_Id;
	private Long consumption_id ;
	private String name;
    private String address;
//    private String email;
//    private String password;
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
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getJan() {
		return jan;
	}
	public void setJan(Integer jan) {
		this.jan = jan;
	}
	public Integer getFeb() {
		return feb;
	}
	public void setFeb(Integer feb) {
		this.feb = feb;
	}
	public Integer getMar() {
		return mar;
	}
	public void setMar(Integer mar) {
		this.mar = mar;
	}
	public Integer getApril() {
		return april;
	}
	public void setApril(Integer april) {
		this.april = april;
	}
	public Integer getMay() {
		return may;
	}
	public void setMay(Integer may) {
		this.may = may;
	}
	public Integer getJune() {
		return june;
	}
	public void setJune(Integer june) {
		this.june = june;
	}
	public Integer getJuly() {
		return july;
	}
	public void setJuly(Integer july) {
		this.july = july;
	}
	public Integer getAugust() {
		return august;
	}
	public void setAugust(Integer august) {
		this.august = august;
	}
	public Integer getSept() {
		return sept;
	}
	public void setSept(Integer sept) {
		this.sept = sept;
	}
	public Integer getOct() {
		return oct;
	}
	public void setOct(Integer oct) {
		this.oct = oct;
	}
	public Integer getNov() {
		return nov;
	}
	public void setNov(Integer nov) {
		this.nov = nov;
	}
	public Integer getDec() {
		return dec;
	}
	public void setDec(Integer dec) {
		this.dec = dec;
	}
	public Long getConsumer_Id() {
		return consumer_Id;
	}
	public void setConsumer_Id(Long consumer_Id) {
		this.consumer_Id = consumer_Id;
	}
	public Long getConsumption_id() {
		return consumption_id;
	}
	public void setConsumption_id(Long consumption_id) {
		this.consumption_id = consumption_id;
	}
    
    
    
    
	

}
