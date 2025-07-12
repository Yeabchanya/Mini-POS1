package com.spring.boot.Mini.POS.System.Management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.Mini.POS.System.Management.DTO.CustomerDTO;
import com.spring.boot.Mini.POS.System.Management.DTO.StaffDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Customer;
import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Mapper.CustomerMapper;
import com.spring.boot.Mini.POS.System.Management.Mapper.StaffMapper;
import com.spring.boot.Mini.POS.System.Management.Repository.CustomerRepository;
import com.spring.boot.Mini.POS.System.Management.Service.CustomerService;
import com.spring.boot.Mini.POS.System.Management.Service.StaffService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO) {
		Customer customer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
		customer = customerService.create(customer);
		return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customer));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long StaffId) {
		Customer customer = customerService.getById(StaffId);
		return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customer));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO) {
		Customer customer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
		Customer customerUpdated = customerService.update(id, customer);
		return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customerUpdated));
	}
	
	@GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllStaff() {
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDTO> customerDTOList = customers.stream()
                .map(CustomerMapper.INSTANCE::toCustomerDTO)
                .toList();
    	return ResponseEntity.ok(customerDTOList);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStaff(@PathVariable("id") Long id) {
		Customer customer = customerService.delete(id);
		return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customer));
	}


}
