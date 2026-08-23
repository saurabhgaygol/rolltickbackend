package com.rolltick.usersetting.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rolltick.usersetting.entity.menutableentity;
import com.rolltick.usersetting.repo.usermenurepo;

@Service
public class menutableservice {
	
	@Autowired
	private usermenurepo userMenuRepo;
	
	public menutableentity savemenudata(menutableentity menudata)
	{
		
		return  userMenuRepo.save(menudata);
		
	}

}
