package com.spring.boot.Mini.POS.System.Management.Service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.Mini.POS.System.Management.DTO.ImportProductDTO;

public interface ImportService {
	
	void ImportProduct(ImportProductDTO importProductDTO);
	
	Map<Integer, String> uploadProduct(MultipartFile fileLocation);
}
