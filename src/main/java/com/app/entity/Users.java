package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor


public class Users {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name="name")
	private String name ;
	
	@Column(name="email")
	private String email ;
	
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	
	
	 public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Roles getRole() {
		return role;
	}



	public void setRole(Roles role) {
		this.role = role;
	}



//	public Consumer getCust() {
//		return cust;
//	}
//
//
//
//	public void setCust(Consumer cust) {
//		this.cust = cust;
//	}



	



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}







//	@OneToOne(cascade = CascadeType.ALL)
//	 private Consumer cust;

}
