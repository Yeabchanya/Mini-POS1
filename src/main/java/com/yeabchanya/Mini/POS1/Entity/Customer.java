package com.yeabchanya.Mini.POS1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CusID")
	private Long CustomerID;

	@Column(name = "CusLocalName", length = 100)
	private String CustomerLocalName;

	@Column(name = "CusEnglishName", length = 100)
	private String CustomerEnglishName;

	@Column(name = "CusEmail", length = 100)
	private String CustomerEmail;

	@Column(name = "CusContact", length = 10)
	private String CustomerContact;

	@Column(name = "CusAddress", length = 100)
	private String CustomerAdress;

}
