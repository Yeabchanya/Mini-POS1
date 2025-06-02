package com.yeabchanya.Mini.POS1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.yeabchanya.Mini.POS1.DTO.SupplierDTO;
import com.yeabchanya.Mini.POS1.Entity.Supplier;

@Mapper
public interface SupplierMapper {

	SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
	
	Supplier toSupplier(SupplierDTO supplierDTO);

	SupplierDTO toSupplierDTO(Supplier supplier);
}
