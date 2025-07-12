package com.spring.boot.Mini.POS.System.Management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.Mini.POS.System.Management.DTO.ProductDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Product;
import com.spring.boot.Mini.POS.System.Management.Mapper.ProductMapper;
import com.spring.boot.Mini.POS.System.Management.Service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
		Product product = ProductMapper.INSTANCE.toProduct(productDTO);
		productService.create(product);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProduct(productDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long productId) {
		Product product = productService.getById(productId);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTO(product));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
		Product product = ProductMapper.INSTANCE.toProduct(productDTO);
		product = productService.update(id, product);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTO(product));
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProduct() {
		List<Product> staffs = productService.getProducts();
		List<ProductDTO> list = staffs.stream()
				.map(ProductMapper.INSTANCE::toProductDTO).toList();
		return ResponseEntity.ok(list);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		Product productDeleted = productService.delete(id);
		return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTO(productDeleted));
	}

}
