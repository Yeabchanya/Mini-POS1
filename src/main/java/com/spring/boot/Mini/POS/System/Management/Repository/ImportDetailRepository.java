package com.spring.boot.Mini.POS.System.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.Mini.POS.System.Management.Entity.ImportDetail;
import com.spring.boot.Mini.POS.System.Management.Entity.ImportDetailId;

@Repository
public interface ImportDetailRepository extends JpaRepository<ImportDetail, ImportDetailId> {

}
