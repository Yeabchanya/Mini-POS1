package com.spring.boot.Mini.POS.System.Management.Service;

import java.util.List;

import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Entity.Supplier;

public interface SupplierService {
	
	Supplier create(Supplier supplier);
	
	Supplier getById(Long Id);

	Supplier update (Long id, Supplier SupplierUpdate);
	
	List<Supplier> getSuppliers();
	
	Supplier delete (long id);
}
