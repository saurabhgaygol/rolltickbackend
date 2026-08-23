package com.rolltick.studentsetting.controllar;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rolltick.studentsetting.entity.studententity;
import com.rolltick.studentsetting.service.studentServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class studentControllar {
	
	@Autowired
	private studentServices studentservice;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudentdata(@Valid @RequestBody studententity StudentEntity)
	{
		
		String data= studentservice.saveStudentdata(StudentEntity);
		
		if(data.equals("Student saved successfully")) 
		{
			return ResponseEntity.ok(data);
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(data);
		
	}
	
	
	@GetMapping("/getdata")
	public ResponseEntity<List<studententity>> getalldata()
	{
		List<studententity> data= studentservice.getallstudentdata();
		
		return ResponseEntity.ok(data);
	}

}
