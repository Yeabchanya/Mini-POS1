package com.spring.boot.Mini.POS.System.Management.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDTO {
	
    private Long proCode;

    private String proName;

    private Long qty;

    private BigDecimal upis;
    
    private BigDecimal sup;

}
