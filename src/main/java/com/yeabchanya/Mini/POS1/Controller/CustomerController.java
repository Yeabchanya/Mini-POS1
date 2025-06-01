package com.yeabchanya.Mini.POS1.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yeabchanya.Mini.POS1.DTO.CustomerDTO;
import com.yeabchanya.Mini.POS1.Entity.Customer;
import com.yeabchanya.Mini.POS1.Mapper.CustomerMapper;
import com.yeabchanya.Mini.POS1.Service.CustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("customers")
public class CustomerController {

	private final CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO) {
		Customer customer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
		customerService.save(customer);
		return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customer));
	}

}
