package com.spring.boot.Mini.POS.System.Management.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ImportProductDTO {

	private LocalDateTime impDate;

	private Long staffId;

	// private String fullName;

	 private Long supplierId;

	//private String supplierName;

	private Long proCode;

	// private String proName;

	private Long qty;

	private BigDecimal price;

}
