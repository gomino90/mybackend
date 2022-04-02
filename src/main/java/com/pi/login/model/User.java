package com.pi.login.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	
	@Column(nullable = false,length=100,name="USER_NAME")
	private String username;
	
	@Column(nullable = false,length=100,unique=true,name="USER_ID")
	private String userId;
	
	@Column(nullable = false,length=100,name="USER_PS")
	private String password;
	
	@Column(nullable = false,length=50,name="USER_EML")
	private String email;
	
	@Column(nullable = false,length=50,name="USER_TELNO")
	private String phone;

	
	private String role;
	
	private String oauth;
	
	@CreationTimestamp
	private Timestamp createDate;





}
