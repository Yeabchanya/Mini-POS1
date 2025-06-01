package com.yeabchanya.Mini.POS1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yeabchanya.Mini.POS1.Entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
