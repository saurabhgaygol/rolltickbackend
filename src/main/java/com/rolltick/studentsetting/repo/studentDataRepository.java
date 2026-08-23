package com.rolltick.studentsetting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolltick.studentsetting.entity.studententity;

public interface studentDataRepository extends JpaRepository<studententity, Long> {
	
	boolean existsBySchoolNameAndSchoolBranchAndGrNumber(
            String schoolName,
            String schoolBranch,
            String grNumber
    );

    boolean existsBySchoolNameAndSchoolBranchAndRfidNumber(
            String schoolName,
            String schoolBranch,
            String rfidNumber
    );
			
	
	

}
