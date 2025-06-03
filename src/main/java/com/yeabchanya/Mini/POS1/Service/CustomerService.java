package com.yeabchanya.Mini.POS1.Service;

import java.util.List;

import com.yeabchanya.Mini.POS1.Entity.Customer;

public interface CustomerService {
	
	Customer save (Customer customer);
	
	Customer getById(Long id);
	
	List<Customer> customers();
	
	Customer update(Long id, Customer customerUpdate);
	
	Customer delete(Long id);

}
