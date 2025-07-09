package com.spring.boot.Mini.POS.System.Management.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class StaffDTO {
	
	private String fullName;

	private String gen;

	private LocalDate dob;

	private String position;

	private BigDecimal salary;

}
