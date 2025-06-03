package com.yeabchanya.Mini.POS1.Service;

import java.util.List;

import com.yeabchanya.Mini.POS1.Entity.Product;

public interface ProductService {
	
	Product create(Product product);
	
	Product getById(Long Id);
	
	List<Product> getAllProduct();
	
	Product update(Long supId, Product ProUpdate);
	
	Product delete (Long id);
}
