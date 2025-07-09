package com.spring.boot.Mini.POS.System.Management.Service;

import java.util.List;

import com.spring.boot.Mini.POS.System.Management.Entity.Staff;

public interface StaffService {
	
	Staff create(Staff staff);
	
	Staff getById(Long Id);

	Staff update (Long id, Staff staffUpdate);
	
	List<Staff> getStaffs();
	
	Staff delete (long id);

}
