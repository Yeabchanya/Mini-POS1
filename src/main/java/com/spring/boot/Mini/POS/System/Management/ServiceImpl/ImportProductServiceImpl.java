package com.spring.boot.Mini.POS.System.Management.ServiceImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.Mini.POS.System.Management.DTO.ImportProductDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Import;
import com.spring.boot.Mini.POS.System.Management.Entity.ImportDetail;
import com.spring.boot.Mini.POS.System.Management.Entity.Product;
import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Entity.Supplier;
import com.spring.boot.Mini.POS.System.Management.Exception.ApiException;
import com.spring.boot.Mini.POS.System.Management.Repository.ImportDetailRepository;
import com.spring.boot.Mini.POS.System.Management.Repository.ImportRepository;
import com.spring.boot.Mini.POS.System.Management.Repository.ProductRepository;
import com.spring.boot.Mini.POS.System.Management.Service.ImportService;
import com.spring.boot.Mini.POS.System.Management.Service.ProductService;
import com.spring.boot.Mini.POS.System.Management.Service.StaffService;
import com.spring.boot.Mini.POS.System.Management.Service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImportProductServiceImpl implements ImportService {

	private final ImportRepository importRepository;
	private final ImportDetailRepository importDetailRepository;
	private final ProductRepository productRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private SupplierService supplierService;

	@Override
	public void ImportProduct(ImportProductDTO importProductDTO) {

		if (importProductDTO.getQty() == null) {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Import Qty Can`t be null");
		}

		// Update Available Product Qty
		Product product = productService.getById(importProductDTO.getProCode()); // get product
		Long Qty = 0l;
		if (product.getQty() != null) {
			Qty = product.getQty();
		}
		product.setQty(Qty + importProductDTO.getQty()); // sum product
		productRepository.save(product); // save to Update Qty Product

		// save Import
		Import importEntity = new Import();
		importEntity.setTotal(importProductDTO.getPrice());
		importEntity.setImpDate(importProductDTO.getImpDate());

		Staff staff = staffService.getById(importProductDTO.getStaffId());
		importEntity.setStaffID(staff); // FK relationship
		importEntity.setFullName(staff.getFullName()); // Snapshot full name

		Supplier supplier = supplierService.getById(importProductDTO.getSupplierId());
		importEntity.setSupplier(supplier);
		importEntity.setSupplierName(supplier.getSupplier());

		Import saveImport = importRepository.save(importEntity);
		System.out.println(saveImport.getImpCode());

		// save Import Detail
		ImportDetail detail = new ImportDetail();
		detail.setImpCode(saveImport);
		detail.setProCode(product);
		detail.setProName(product.getProName());
		Long Q = importProductDTO.getQty();
		detail.setQty(Q);
		BigDecimal P = importProductDTO.getPrice();
		detail.setPrice(P);
		BigDecimal amount = BigDecimal.valueOf(Q).multiply(P);
		detail.setAmount(amount);

		importDetailRepository.save(detail); // TODO
	}

	@Override
	public Map<Integer, String> uploadProduct(MultipartFile fileLocation) {
		try {
			Workbook workbook = new XSSFWorkbook(fileLocation.getInputStream());
			Sheet sheet = workbook.getSheet("products");
			Iterator<Row> RowIterator = sheet.iterator();

			RowIterator.next();

			while (RowIterator.hasNext()) {
				Integer rowNumber = 0;

				Row row = RowIterator.next();
				int cellIndex = 0;

				Cell cellNO = row.getCell(cellIndex++);
				rowNumber = (int) cellNO.getNumericCellValue();

				Cell cellStaffID = row.getCell(cellIndex++);
				long StaffID = (long) cellStaffID.getNumericCellValue();

				Cell cellSupplierID = row.getCell(cellIndex++);
				long SupplierID = (long) cellSupplierID.getNumericCellValue();

				Cell cellProductCode = row.getCell(cellIndex++);
				long ProductCode = (long) cellProductCode.getNumericCellValue();

				Cell cellQuantity = row.getCell(cellIndex++);
				long Quantity = (long) cellQuantity.getNumericCellValue();

				Cell cellPrice = row.getCell(cellIndex++);
				double Price = cellPrice.getNumericCellValue();

				Cell cellImportDate = row.getCell(cellIndex++);
				LocalDateTime ImportDate = cellImportDate.getLocalDateTimeCellValue();

				// Update Qty Product
				Product product = productService.getById(ProductCode); // get product
				Long QuantityOld = 0l;

				if (product.getQty() != null) {
					QuantityOld = product.getQty();
				}
				product.setQty(QuantityOld + Quantity); // sum product

				productRepository.save(product); // save to Update Qty Product

				// save Import
				Import importEntity = new Import();
				importEntity.setTotal(BigDecimal.valueOf(Price));
				importEntity.setImpDate(ImportDate);

				Staff staff = staffService.getById(StaffID);
				importEntity.setStaffID(staff); // FK relationship
				importEntity.setFullName(staff.getFullName()); // Snapshot full name

				Supplier supplier = supplierService.getById(SupplierID);
				importEntity.setSupplier(supplier);
				importEntity.setSupplierName(supplier.getSupplier());

				Import saveImport = importRepository.save(importEntity);
				System.out.println(saveImport.getImpCode());

				// save Import Detail
				ImportDetail detail = new ImportDetail();
				detail.setImpCode(saveImport);
				detail.setProCode(product);
				detail.setProName(product.getProName());
				detail.setQty(Quantity);
				BigDecimal price = BigDecimal.valueOf(Price);
				detail.setPrice(price);
				BigDecimal amount = BigDecimal.valueOf(Quantity).multiply(price);
				detail.setAmount(amount);

				importDetailRepository.save(detail); // TODO

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
