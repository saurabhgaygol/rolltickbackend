package com.rolltick.rfidsetting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolltick.rfidsetting.entity.rfidrawdata;

public interface rfidRawDataRepository extends JpaRepository<rfidrawdata, Long> {

}
