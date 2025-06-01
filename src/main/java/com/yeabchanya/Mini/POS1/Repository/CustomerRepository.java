package com.yeabchanya.Mini.POS1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yeabchanya.Mini.POS1.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
