package com.spring.boot.Mini.POS.System.Management.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.spring.boot.Mini.POS.System.Management.DTO.SupplierDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Supplier;

@Mapper
public interface SupplierMapper {
	
	SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
	
	Supplier toSupplier(SupplierDTO supplierDTO);
	
	SupplierDTO toSupplierDTO(Supplier supplier);

}
