package com.spring.boot.Mini.POS.System.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.Mini.POS.System.Management.Entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	
}
