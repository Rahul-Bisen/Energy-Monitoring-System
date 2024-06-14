package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Consumer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="consumer_id", nullable = false)
	private Long consumer_Id ;
	
	private String name ;
	
	@Column(name="email" , nullable = false)
	private String email;
	
	@Column(name="password" , nullable = false)
	private String password;
	
	private String address;
	
	//update on 16
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users user;
	
	
	
	 @OneToMany(fetch = FetchType.EAGER,
	 mappedBy = "consumer", cascade = CascadeType.ALL)
	    private List<Consumption> list;
	 
	 
	 
//	 @OneToOne(cascade = CascadeType.ALL)
//	    @JoinColumn(name = "user_id", referencedColumnName = "userId")
//	 private Users user;
//	

}
