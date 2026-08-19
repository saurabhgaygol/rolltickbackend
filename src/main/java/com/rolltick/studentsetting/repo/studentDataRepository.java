package com.rolltick.studentsetting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolltick.studentsetting.entity.studententity;

public interface studentDataRepository extends JpaRepository<studententity, Long> {

}
