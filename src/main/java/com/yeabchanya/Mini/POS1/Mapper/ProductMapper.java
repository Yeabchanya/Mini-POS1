package com.yeabchanya.Mini.POS1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.yeabchanya.Mini.POS1.DTO.ProductDTO;
import com.yeabchanya.Mini.POS1.Entity.Product;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	Product toProduct(ProductDTO productDTO);

	ProductDTO toProductDTO(Product product);
}
