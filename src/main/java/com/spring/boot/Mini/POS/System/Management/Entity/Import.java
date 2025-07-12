package com.spring.boot.Mini.POS.System.Management.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbImports")
public class Import {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImpCode")
    private long impCode;

    @Column(name = "ImpDate")
    private LocalDateTime impDate;

    @ManyToOne
    @JoinColumn(name = "staffID")
    private Staff staff;

    @Column(name = "FullName", length = 100)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "supID")
    private Supplier supplier;

    @Column(name = "Supplier", length = 100)
    private String supplierName;

    @Column(name = "Total")
    private BigDecimal total;
    
}