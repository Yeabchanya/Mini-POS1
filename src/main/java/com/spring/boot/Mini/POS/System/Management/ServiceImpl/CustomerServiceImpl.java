package com.spring.boot.Mini.POS.System.Management.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.Mini.POS.System.Management.Entity.Customer;
import com.spring.boot.Mini.POS.System.Management.Exception.ResourceNotFoundException;
import com.spring.boot.Mini.POS.System.Management.Repository.CustomerRepository;
import com.spring.boot.Mini.POS.System.Management.Service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository customerRepository;

	@Override
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getById(Long Id) {
		return customerRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Customer", Id));
	}

	@Override
	public Customer update(Long id, Customer customerUpdate) {
		Customer customer = getById(id);
		customer.setCusName(customerUpdate.getCusName());
		customer.setCusContact(customerUpdate.getCusContact());
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer delete(long id) {
		Customer customer = getById(id);
		customerRepository.delete(customer);
		return customer;
	}

}
