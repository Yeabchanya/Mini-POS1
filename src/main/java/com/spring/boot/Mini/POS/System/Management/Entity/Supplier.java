package com.spring.boot.Mini.POS.System.Management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "tbSuppliers")
public class Supplier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supID")
    private Long supId;

    @Column(name = "Supplier", length = 100)
    private String supplier;

    @Column(name = "SupAdd", length = 100)
    private String supAdd;

    @Column(name = "SupCon", length = 100)
    private String supCon;
}
