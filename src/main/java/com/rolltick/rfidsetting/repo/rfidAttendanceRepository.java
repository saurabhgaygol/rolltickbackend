package com.rolltick.rfidsetting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.rolltick.rfidsetting.entity.rfidAttendance;

public interface rfidAttendanceRepository extends JpaRepository<rfidAttendance, Long> {
	
	

}
