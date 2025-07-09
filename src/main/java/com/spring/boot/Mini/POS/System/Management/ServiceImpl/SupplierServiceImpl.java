package com.spring.boot.Mini.POS.System.Management.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Entity.Supplier;
import com.spring.boot.Mini.POS.System.Management.Exception.ResourceNotFoundException;
import com.spring.boot.Mini.POS.System.Management.Repository.StaffRepository;
import com.spring.boot.Mini.POS.System.Management.Repository.SupplierRepository;
import com.spring.boot.Mini.POS.System.Management.Service.StaffService;
import com.spring.boot.Mini.POS.System.Management.Service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
	
	private final SupplierRepository supplierRepository;
	
	
	@Override
	public Supplier create(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier getById(Long Id) {
		return supplierRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Suppiler", Id));
	}

	@Override
	public Supplier update(Long id, Supplier SupplierUpdate) {
		Supplier supplier = getById(id);
		supplier.setSupplier(SupplierUpdate.getSupplier());
		supplier.setSupAdd(SupplierUpdate.getSupAdd());
		supplier.setSupCon(SupplierUpdate.getSupCon());
		return supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier delete(long id) {
		Supplier supplier = getById(id);
		supplierRepository.delete(supplier);
		return supplier;
	}

	

}
