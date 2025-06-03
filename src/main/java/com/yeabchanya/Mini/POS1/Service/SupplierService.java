package com.yeabchanya.Mini.POS1.Service;

import java.util.List;

import com.yeabchanya.Mini.POS1.Entity.Supplier;

public interface SupplierService {
	
	Supplier create(Supplier supplier);
	
	Supplier getSupplierById(Long Id);
	
	List<Supplier> getAllSupplier();
	
	Supplier update(Long supId, Supplier supUpdate);
	
	Supplier delete (Long id);

}

