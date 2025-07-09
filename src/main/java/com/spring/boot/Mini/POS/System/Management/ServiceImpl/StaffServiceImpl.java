package com.spring.boot.Mini.POS.System.Management.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Exception.ResourceNotFoundException;
import com.spring.boot.Mini.POS.System.Management.Repository.StaffRepository;
import com.spring.boot.Mini.POS.System.Management.Service.StaffService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

	private final StaffRepository staffRepository;

	@Override
	public Staff create(Staff staff) {
		return staffRepository.save(staff);
	}

	@Override
	public Staff getById(Long Id) {
		return staffRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Staff", Id));
	}

	@Override
	public Staff update(Long id, Staff staffUpdate) {
		Staff staff = getById(id);
		staff.setFullName(staffUpdate.getFullName());
		staff.setGen(staffUpdate.getGen());
		staff.setDob(staffUpdate.getDob());
		staff.setPosition(staffUpdate.getPosition());
		staff.setSalary(staffUpdate.getSalary());
		return staffRepository.save(staff);
	}

	@Override
	public List<Staff> getStaffs() {
		return staffRepository.findAll();
	}

	@Override
	public Staff delete(long id) {
		Staff staff = getById(id);
		staffRepository.delete(staff);
		return staff;
	}

}
