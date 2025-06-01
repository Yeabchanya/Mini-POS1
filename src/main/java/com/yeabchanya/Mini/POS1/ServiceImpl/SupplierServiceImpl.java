package com.yeabchanya.Mini.POS1.ServiceImpl;

import org.springframework.stereotype.Service;

import com.yeabchanya.Mini.POS1.Entity.Supplier;
import com.yeabchanya.Mini.POS1.Repository.SupplierRepository;
import com.yeabchanya.Mini.POS1.Service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
	
	private final SupplierRepository supplierRepository;

	@Override
	public Supplier create(Supplier supplier) {
		System.out.println(supplier); // Debug
		return supplierRepository.save(supplier);
	}

}
