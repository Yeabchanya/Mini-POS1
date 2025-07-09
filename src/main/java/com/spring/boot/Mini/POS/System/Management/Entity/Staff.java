package com.spring.boot.Mini.POS.System.Management.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "tbStaffs")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staffID")
	private Long staffID;

	@Column(name = "FullName", length = 50)
	private String fullName;

	@Column(name = "Gen")
	private String gen;

	@Column(name = "Dob")
	private LocalDate dob;

	@Column(name = "Position", length = 50)
	private String position;

	@Column(name = "Salary")
	private BigDecimal salary;

	@Column(name = "Stopwork")
	private Boolean Stopwork;
}
