package com.spring.boot.Mini.POS.System.Management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tbCustomers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cusID")
	private Long cusId;

	@Column(name = "CusName", nullable = false, length = 100)
	private String cusName;

	@Column(name = "CusContact", length = 10, unique = true)
	private String cusContact;
}