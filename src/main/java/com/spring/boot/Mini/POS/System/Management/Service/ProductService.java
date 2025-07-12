package com.spring.boot.Mini.POS.System.Management.Service;

import java.util.List;

import com.spring.boot.Mini.POS.System.Management.Entity.Product;

public interface ProductService {
	
	
	Product create(Product product);
	
	Product getById(Long Id);

	Product update (Long id, Product productUpdate);
	
	List<Product> getProducts();
	
	Product delete (long id);

}
