package com.spring.boot.Mini.POS.System.Management.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbImportdetails")
//@IdClass(ImportDetailId.class)
public class ImportDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "ImpCode")
    private Import impCode;

    @Id
    @ManyToOne
    @JoinColumn(name = "ProCode")
    private Product productCode;

    @Column(name = "ProName", length = 100)
    private String proName;

    @Column(name = "Qty")
    private Long qty;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Amount")
    private BigDecimal amount;
}