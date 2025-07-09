package com.spring.boot.Mini.POS.System.Management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.Mini.POS.System.Management.DTO.StaffDTO;
import com.spring.boot.Mini.POS.System.Management.DTO.SupplierDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Entity.Supplier;
import com.spring.boot.Mini.POS.System.Management.Mapper.StaffMapper;
import com.spring.boot.Mini.POS.System.Management.Mapper.SupplierMapper;
import com.spring.boot.Mini.POS.System.Management.Service.StaffService;
import com.spring.boot.Mini.POS.System.Management.Service.SupplierService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/suppliers")
public class SupplierController {

	private final SupplierService supplierService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody SupplierDTO supplierDTO) {
		Supplier supplier = SupplierMapper.INSTANCE.toSupplier(supplierDTO);
		supplier = supplierService.create(supplier);
		return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTO(supplier));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long SupplierId) {
		Supplier supplier = supplierService.getById(SupplierId);
		return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTO(supplier));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SupplierDTO supplierDTO) {
		Supplier supplier = SupplierMapper.INSTANCE.toSupplier(supplierDTO);
		supplier = supplierService.update(id, supplier);
		return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTO(supplier));
	}
	
	@GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllStaff() {
        List<Supplier> suppliers = supplierService.getSuppliers();
        		List<SupplierDTO> list = suppliers.stream()
                .map(SupplierMapper.INSTANCE::toSupplierDTO)
                .toList();

        return ResponseEntity.ok(list);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	    Supplier supplier = supplierService.delete(id);
	    return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTO(supplier));
	}


}
