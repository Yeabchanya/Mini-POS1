package com.spring.boot.Mini.POS.System.Management.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.Mini.POS.System.Management.DTO.ImportProductDTO;
import com.spring.boot.Mini.POS.System.Management.Service.ImportService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/imports")
public class ImportProductController {

	private final ImportService importService;

	@PostMapping("product")
	public ResponseEntity<?> importProduct(@RequestBody @Validated ImportProductDTO importDTO) {
		importService.ImportProduct(importDTO);
		return ResponseEntity.ok().build();
	}

	@PostMapping("updoadProducts")
	public ResponseEntity<?> uploadProduct(@RequestParam("file") MultipartFile file) {
		Map<Integer, String> uploadProduct = importService.uploadProduct(file);
		return ResponseEntity.ok(uploadProduct);
	}

}
