package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

public class ConsumerDto {
	
	private long consumer_id ;
	private String name;
	private String address;
	public long getConsumer_id() {
		return consumer_id;
	}
	public void setConsumer_id(long consumer_id) {
		this.consumer_id = consumer_id;
	}
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
	
	
	

}
