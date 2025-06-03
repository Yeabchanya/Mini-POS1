package com.yeabchanya.Mini.POS1.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yeabchanya.Mini.POS1.Entity.Product;
import com.yeabchanya.Mini.POS1.Exception.ResourceNotFoundException;
import com.yeabchanya.Mini.POS1.Repository.ProductRepository;
import com.yeabchanya.Mini.POS1.Service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long Id) {
		return productRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", Id));
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product update(Long supId, Product ProUpdate) {
		Product product = getById(supId);
		product.setProName(ProUpdate.getProName());
		product.setQuantityInStock(ProUpdate.getQuantityInStock());
		product.setUnitPriceInStockPIS(ProUpdate.getUnitPriceInStockPIS());
		product.setSaleUnitPrice(ProUpdate.getSaleUnitPrice());
		return productRepository.save(product);
	}

	@Override
	public Product delete(Long id) {
		Product product = getById(id);
		productRepository.delete(product);
		return product;
	}

}
