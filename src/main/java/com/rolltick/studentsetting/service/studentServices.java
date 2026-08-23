package com.rolltick.studentsetting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolltick.studentsetting.entity.studententity;
import com.rolltick.studentsetting.repo.studentDataRepository;

@Service
public class studentServices {
	
	@Autowired
	private studentDataRepository Studentdatarepo;
	
	public String saveStudentdata(studententity student) 
	{
		
		if(Studentdatarepo.existsBySchoolNameAndSchoolBranchAndGrNumber(student.getSchoolName(), student.getSchoolBranch(), student.getGrNumber())) 
		{
			return "GR Number already exists for this school and branch";
		}
		
		if(Studentdatarepo.existsBySchoolNameAndSchoolBranchAndRfidNumber(student.getSchoolName(), student.getSchoolBranch(), student.getRfidNumber()))
		{
			return "Rfid Data already exists for this school and branch";
		}
		
		
		
        Studentdatarepo.save(student);
        
        return "Student saved successfully";
	}

	
	public List<studententity> getallstudentdata() 
	{
		return Studentdatarepo.findAll();
	}
	
	
	
}
