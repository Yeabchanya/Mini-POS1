package com.spring.boot.Mini.POS.System.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.Mini.POS.System.Management.Entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	
}
