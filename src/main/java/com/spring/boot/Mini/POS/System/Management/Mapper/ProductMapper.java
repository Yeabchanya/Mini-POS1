package com.spring.boot.Mini.POS.System.Management.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.spring.boot.Mini.POS.System.Management.DTO.ProductDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Product;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	Product toProduct(ProductDTO productDTO);

	ProductDTO toProductDTO(Product product);
}
