package com.spring.boot.Mini.POS.System.Management.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.Mini.POS.System.Management.Entity.Product;
import com.spring.boot.Mini.POS.System.Management.Exception.ResourceNotFoundException;
import com.spring.boot.Mini.POS.System.Management.Repository.ProductRepository;
import com.spring.boot.Mini.POS.System.Management.Service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long Id) {
		return productRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Product", Id));
	}

	@Override
	public Product update(Long id, Product productUpdate) {
		Product product = getById(id);
		product.setProCode(productUpdate.getProCode());
		product.setProName(productUpdate.getProName());
		product.setQty(productUpdate.getQty());
		product.setUpis(productUpdate.getUpis());
		product.setSup(productUpdate.getSup());
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product delete(long id) {
		Product product = getById(id);
		productRepository.delete(product);
		return product;
	}

}
