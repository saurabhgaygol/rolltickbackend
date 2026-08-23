package com.rolltick.usersetting.repo;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolltick.usersetting.entity.usertableentity;

public interface userTableRepository extends JpaRepository<usertableentity, Long>{
	
    Optional<usertableentity> findByUserUniqId(String userUniqId);

    Optional<usertableentity> findByUserId(String userId);
	
}
