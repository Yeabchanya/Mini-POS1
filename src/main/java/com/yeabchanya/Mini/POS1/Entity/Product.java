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
@Table(name = "tbProducts")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProCode")
	private Long ProCode;

	@Column(name = "ProName")
	private String ProName;

	@Column(name = "Qty")
	private Long QuantityInStock;

	@Column(name = "UPIS")
	private Double UnitPriceInStockPIS;

	@Column(name = "SUP")
	private Double SaleUnitPrice;

}
