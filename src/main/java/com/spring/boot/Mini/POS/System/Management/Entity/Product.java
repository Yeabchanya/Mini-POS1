package com.spring.boot.Mini.POS.System.Management.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "tbProducts")
public class Product {

	@Id
    @Column(name = "ProCode")
    private Long proCode;

    @Column(name = "ProName", length = 100)
    private String proName;

    @Column(name = "Qty")
    private Long qty;

    @Column(name = "UPIS")
    private BigDecimal upis;  // Unit price in stock

    @Column(name = "SUP")
    private BigDecimal sup;   // Sale unit price
}
