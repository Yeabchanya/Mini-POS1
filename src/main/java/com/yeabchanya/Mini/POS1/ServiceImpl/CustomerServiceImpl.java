package com.yeabchanya.Mini.POS1.ServiceImpl;

import org.springframework.stereotype.Service;

import com.yeabchanya.Mini.POS1.Entity.Customer;
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

}
