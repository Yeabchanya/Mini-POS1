package com.yeabchanya.Mini.POS1.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeabchanya.Mini.POS1.DTO.ProductDTO;
import com.yeabchanya.Mini.POS1.Entity.Product;
import com.yeabchanya.Mini.POS1.Mapper.ProductMapper;
import com.yeabchanya.Mini.POS1.Service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductConntroller {

	private final ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
		Product product = ProductMapper.INSTANCE.toProduct(productDTO);
		product = productService.create(product);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTO(product));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Product product = productService.getById(id);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTO(product));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllProduct() {
		List<ProductDTO> list = productService.getAllProduct()
				.stream()
				.map(Product -> ProductMapper.INSTANCE.toProductDTO(Product))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
		Product product = ProductMapper.INSTANCE.toProduct(productDTO);
		Product updated = productService.update(id, product);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTO(updated));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		Product proDeleted = productService.delete(id);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTO(proDeleted));
	}
	
	

}
