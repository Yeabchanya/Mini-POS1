package com.yeabchanya.Mini.POS1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeabchanya.Mini.POS1.Entity.Supplier;
import com.yeabchanya.Mini.POS1.Service.SupplierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("suppliers")
public class SupplierController {
	
	private final SupplierService supplierService;
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Supplier supplier) {
		System.out.println("Received supplier: " + supplier);
		supplierService.create(supplier);
		return ResponseEntity.status(HttpStatus.CREATED).body("Supplier created successfully");

	}
}
