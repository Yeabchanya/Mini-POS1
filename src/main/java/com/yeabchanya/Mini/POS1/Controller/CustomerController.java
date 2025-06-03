package com.yeabchanya.Mini.POS1.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Customer customer = customerService.getById(id);
	 return	ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customer));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCustomers() {
		List<CustomerDTO> list = customerService.customers()
				.stream()
				.map(Customer -> CustomerMapper.INSTANCE.toCustomerDTO(Customer))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> updateSupplierById(@PathVariable("id") Long id){
		Customer customerdeleted = customerService.delete(id);
		return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customerdeleted));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateSupplierById(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO) {
		Customer customer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
		customer = customerService.update(id, customer);
		return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customer));
	}
}
