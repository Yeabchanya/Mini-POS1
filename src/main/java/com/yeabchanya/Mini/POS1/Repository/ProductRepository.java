package com.yeabchanya.Mini.POS1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yeabchanya.Mini.POS1.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
