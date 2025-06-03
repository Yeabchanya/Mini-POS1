package com.yeabchanya.Mini.POS1.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yeabchanya.Mini.POS1.Entity.Customer;
import com.yeabchanya.Mini.POS1.Exception.ResourceNotFoundException;
import com.yeabchanya.Mini.POS1.Repository.CustomerRepository;
import com.yeabchanya.Mini.POS1.Service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier", id));

	}

	@Override
	public List<Customer> customers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer delete(Long id) {
		Customer customer = getById(id);
		customerRepository.delete(customer);
		return customer;
	}

	@Override
	public Customer update(Long id, Customer customerUpdate) {
		Customer customer = getById(id);
		customer.setCustomerLocalName(customerUpdate.getCustomerLocalName());
		customer.setCustomerEnglishName(customerUpdate.getCustomerEnglishName());
		customer.setCustomerEmail(customerUpdate.getCustomerEmail());
		customer.setCustomerAdress(customerUpdate.getCustomerAdress());
		return customerRepository.save(customer);
	}

}
