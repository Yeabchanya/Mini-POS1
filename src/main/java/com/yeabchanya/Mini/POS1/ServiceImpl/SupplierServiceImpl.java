package com.yeabchanya.Mini.POS1.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yeabchanya.Mini.POS1.Entity.Supplier;
import com.yeabchanya.Mini.POS1.Exception.ResourceNotFoundException;
import com.yeabchanya.Mini.POS1.Repository.SupplierRepository;
import com.yeabchanya.Mini.POS1.Service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
	
	private final SupplierRepository supplierRepository;

	@Override
	public Supplier create(Supplier supplier) {
		//System.out.println(supplier); // Debug
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier getSupplierById(Long Id) {
		return supplierRepository
				.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier", Id));
	}

	@Override
	public List<Supplier> getAllSupplier() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier update(Long supId, Supplier supUpdate) {
		Supplier supplier = getSupplierById(supId);
		supplier.setSupplierName(supUpdate.getSupplierName());
		supplier.setSupAddress(supUpdate.getSupAddress());
		supplier.setSupContact(supUpdate.getSupContact());
		return supplierRepository.save(supplier);
	}

}
