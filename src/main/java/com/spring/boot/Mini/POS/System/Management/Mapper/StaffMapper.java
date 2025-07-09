package com.spring.boot.Mini.POS.System.Management.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.spring.boot.Mini.POS.System.Management.DTO.StaffDTO;
import com.spring.boot.Mini.POS.System.Management.Entity.Staff;

@Mapper
public interface StaffMapper {
	
	StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
	
	Staff toStaff(StaffDTO staffDTO);
	
	StaffDTO toStaffDTO(Staff staff);

}
