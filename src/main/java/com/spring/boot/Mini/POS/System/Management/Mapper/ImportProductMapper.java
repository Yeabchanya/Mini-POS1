package com.spring.boot.Mini.POS.System.Management.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // or omit "spring" if not using Spring DI
public interface ImportProductMapper {

	ImportProductMapper INSTANCE = Mappers.getMapper(ImportProductMapper.class);

//	@Mapping(source = "proCode", target = "proCode.proCode") // map Long → Product
//	@Mapping(source = "impDate", target = "impCode.impDate") // optional, just for completeness
//	@Mapping(target = "impCode", ignore = true) // will be set in service manually
//	@Mapping(target = "amount", expression = "java(importProductDTO.getPrice().multiply(java.math.BigDecimal.valueOf(importProductDTO.getQty())))")
//	ImportDetail toProductImportDetail(ImportProductDTO importProductDTO);
//
//	@Mapping(source = "proCode.proCode", target = "proCode")
//	@Mapping(source = "impCode.impDate", target = "impDate") // if you want impDate in DTO
//	@Mapping(source = "qty", target = "qty")
//	@Mapping(source = "price", target = "price")
//	ImportProductDTO toProductImportDetailDTO(ImportDetail importDetail);

}
