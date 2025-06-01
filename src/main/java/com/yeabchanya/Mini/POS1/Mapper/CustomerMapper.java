package com.yeabchanya.Mini.POS1.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.yeabchanya.Mini.POS1.DTO.CustomerDTO;
import com.yeabchanya.Mini.POS1.Entity.Customer;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	Customer toCustomer(CustomerDTO customerDTO);

	CustomerDTO toCustomerDTO(Customer customer);

}
