package com.spring.boot.Mini.POS.System.Management.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.spring.boot.Mini.POS.System.Management.Entity.Product;
import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Entity.Supplier;

import lombok.Data;

@Data
public class ImportProductDTO {

	private LocalDateTime impDate;

	private Long staffId;

	//private String fullName;

	//private Supplier supplierId;

	private String supplierName;

	
	private Long productCode;

	//private String proName;

	private Long qty;

	private BigDecimal price;

}
