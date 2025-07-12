package com.spring.boot.Mini.POS.System.Management.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring.boot.Mini.POS.System.Management.DTO.ImportProductDTO;
import com.spring.boot.Mini.POS.System.Management.Exception.ApiException;
import com.spring.boot.Mini.POS.System.Management.Repository.ImportDetailRepository;
import com.spring.boot.Mini.POS.System.Management.Repository.ImportRepository;
import com.spring.boot.Mini.POS.System.Management.Service.ImportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImportProductServiceImpl implements ImportService{
	
	private final ImportRepository importRepository;
	private final ImportDetailRepository importDetailRepository;

	@Override
	public void ImortProduct(ImportProductDTO importProductDTO) {
		if(importProductDTO.getQty() == null) {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Import Qty Can`t be null");
		}
		
		
		// Update Available Product unit
	}

}
