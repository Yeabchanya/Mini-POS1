package com.yeabchanya.Mini.POS1.DTO;

import lombok.Data;

@Data
public class ProductDTO {

	private String ProName;

	private Long QuantityInStock;

	private Double UnitPriceInStockPIS;

	private Double SaleUnitPrice;
}
