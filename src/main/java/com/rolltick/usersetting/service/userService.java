package com.rolltick.usersetting.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rolltick.usersetting.entity.usertableentity;
import com.rolltick.usersetting.repo.userTableRepository;

@Service
public class userService {
	
	@Autowired
	private userTableRepository usertablerepository;
	
	public usertableentity createUser(usertableentity newUser) {

        String role = newUser.getUserRole();
        String parentId = newUser.getParentUserId();

        // Manager ka parent nahi hoga
        if (role.equals("MANAGER")) {
            newUser.setParentUserId(null);
        } 
        else {

            // Parent compulsory
            if (parentId == null || parentId.isBlank()) {
                throw new RuntimeException("Parent user is required");
            }

            // Parent user find karo
            usertableentity parent =
                    usertablerepository.findByUserUniqId(parentId)
                    .orElseThrow(() ->
                        new RuntimeException("Parent user not found"));

            // Role hierarchy check
            if (role.equals("SUB_MANAGER")
                    && !parent.getUserRole().equals("MANAGER")) {

                throw new RuntimeException(
                    "SUB_MANAGER must be under MANAGER");
            }

            if (role.equals("SCHOOL_ADMIN")
                    && !parent.getUserRole().equals("SUB_MANAGER")) {

                throw new RuntimeException(
                    "SCHOOL_ADMIN must be under SUB_MANAGER");
            }

            if (role.equals("SCHOOL_BRANCH")
                    && !parent.getUserRole().equals("SCHOOL_ADMIN")) {

                throw new RuntimeException(
                    "SCHOOL_BRANCH must be under SCHOOL_ADMIN");
            }

            if (role.equals("USER")
                    && !parent.getUserRole().equals("SCHOOL_BRANCH")) {

                throw new RuntimeException(
                    "USER must be under SCHOOL_BRANCH");
            }
        }

        return usertablerepository.save(newUser);
    }
}
