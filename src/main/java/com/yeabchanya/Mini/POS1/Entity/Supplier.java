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
@Table(name = "tbSuppliers")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SupID")
	private Long SupplierID;
	
	@Column(name = "Supplier", length = 100)
	private String SupplierName;
	
	@Column(name = "SupAdd", length = 100)
	private String SupAddress;
	
	@Column(name = "SupCon", length = 20)
	private String SupContact;


}
