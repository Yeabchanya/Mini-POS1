package com.yeabchanya.Mini.POS1.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeabchanya.Mini.POS1.DTO.SupplierDTO;
import com.yeabchanya.Mini.POS1.Entity.Supplier;
import com.yeabchanya.Mini.POS1.Mapper.SupplierMapper;
import com.yeabchanya.Mini.POS1.Service.SupplierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("suppliers")
public class SupplierController {

	private final SupplierService supplierService;

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SupplierDTO supplierDTO) {
		Supplier supplier = SupplierMapper.INSTANCE.toSupplier(supplierDTO);
		supplier = supplierService.create(supplier);
		return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTO(supplier));
		// .status(HttpStatus.CREATED).body("Supplier created successfully");

	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Supplier supplier = supplierService.getSupplierById(id);
		return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTO(supplier));
	}

	@GetMapping
	public ResponseEntity<?> getAllSuppliers() {
		List<SupplierDTO> list = supplierService.getAllSupplier()
				.stream()
				.map(Supplier -> SupplierMapper.INSTANCE.toSupplierDTO(Supplier))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateSupplierById(@PathVariable("id") Long id, @RequestBody SupplierDTO supplierDTO) {
		Supplier supplier = SupplierMapper.INSTANCE.toSupplier(supplierDTO);
		supplier = supplierService.update(id, supplier);
		return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTO(supplier));
	}
}
