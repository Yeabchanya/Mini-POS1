package com.spring.boot.Mini.POS.System.Management.Service;

import java.util.List;

import com.spring.boot.Mini.POS.System.Management.Entity.Customer;

public interface CustomerService {
	
	Customer create(Customer customer);
	
	Customer getById(Long Id);

	Customer update (Long id, Customer customerUpdate);
	
	List<Customer> getCustomers();
	
	Customer delete (long id);

}
