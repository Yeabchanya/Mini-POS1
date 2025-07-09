package com.spring.boot.Mini.POS.System.Management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.Mini.POS.System.Management.DTO.StaffDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Staff;
import com.spring.boot.Mini.POS.System.Management.Mapper.StaffMapper;
import com.spring.boot.Mini.POS.System.Management.Service.StaffService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/staffs")
public class StaffController {

	private final StaffService staffService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody StaffDTO staffDTO) {
		Staff staff = StaffMapper.INSTANCE.toStaff(staffDTO);
		staff = staffService.create(staff);
		return ResponseEntity.ok(StaffMapper.INSTANCE.toStaffDTO(staff));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long StaffId) {
		Staff staff = staffService.getById(StaffId);
		return ResponseEntity.ok(StaffMapper.INSTANCE.toStaffDTO(staff));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody StaffDTO staffDTO) {
		Staff staff = StaffMapper.INSTANCE.toStaff(staffDTO);
		Staff staffUpdated = staffService.update(id, staff);
		return ResponseEntity.ok(StaffMapper.INSTANCE.toStaffDTO(staffUpdated));
	}
	
	@GetMapping
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        List<Staff> staffs = staffService.getStaffs();
        List<StaffDTO> dtoList = staffs.stream()
                .map(StaffMapper.INSTANCE::toStaffDTO)
                .toList();

        return ResponseEntity.ok(dtoList);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStaff(@PathVariable("id") Long id) {
	    Staff staffDeleted = staffService.delete(id);
	    return ResponseEntity.ok(StaffMapper.INSTANCE.toStaffDTO(staffDeleted));
	}


}
