package com.rolltick.usersetting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolltick.usersetting.entity.menutableentity;


public interface usermenurepo extends JpaRepository<menutableentity, Long> {

}
