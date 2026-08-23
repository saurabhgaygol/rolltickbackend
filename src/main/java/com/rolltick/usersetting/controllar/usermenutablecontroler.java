package com.rolltick.usersetting.controllar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rolltick.usersetting.entity.menutableentity;
import com.rolltick.usersetting.service.menutableservice;

@RestController
@RequestMapping("/api/menu")
public class usermenutablecontroler {
	
	@Autowired
	private menutableservice menuTableService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createMenu(@RequestBody  menutableentity menudata)
	{
		menuTableService.savemenudata(menudata);
		
		return  ResponseEntity.ok("ok save data ");
	}
}
