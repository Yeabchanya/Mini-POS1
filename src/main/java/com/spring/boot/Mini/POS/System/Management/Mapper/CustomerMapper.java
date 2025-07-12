package com.spring.boot.Mini.POS.System.Management.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.spring.boot.Mini.POS.System.Management.DTO.CustomerDTO;
import com.spring.boot.Mini.POS.System.Management.DTO.ProductDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Customer;
import com.spring.boot.Mini.POS.System.Management.Entity.Product;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	Customer toCustomer(CustomerDTO customerDTO);
	 
	CustomerDTO toCustomerDTO(Customer customer);

}
