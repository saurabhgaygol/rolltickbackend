package com.rolltick.studentsetting.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="students_alldata")
public class studententity {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="shoool_name")
    private String schoolName; 
	
	@Column(name="shoool_branch")
    private String schoolBranch; 
	
	@NotBlank
	@Size(max = 3)
	@Column(name="class", nullable = false)
    private String schoolClass; 
	
	@NotBlank
	@Size(max = 5)
	@Column(name="division")
    private String schoolDivision; 
	
	@Column(name= "gr_number")
	private String grNumber;
	
	@Column(name= "student_name")
	private String studentName;
	
	@Column(name= "rfid_number")
	private String rfidNumber;
	
	@Column(name= "parent_nmae1")
	private String parentNmae1;
	
	@Column(name= "mobile_number1")
	private String mobileNumber1;
	
	@Column(name= "parent_nmae2")
	private String parentNmae2;
	
	@Column(name= "mobile_number2")
	private String mobileNumber2;
	
	@Column(name= "created_date")
	private LocalDateTime createddate;
	
	@Column(name= "created_userid")
	private String createduserid;
	
	@Column(name = "parent_sms_send1", nullable = false)
	private boolean parentSmsSend1;
	
	@Column(name = "parent_sms_send2", nullable = false)
	private boolean parentSmsSend2;
	
	@Column(name = "parent_access", nullable = false)
	private boolean parentAccess = true;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//geter seter mathod

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolBranch() {
		return schoolBranch;
	}

	public void setSchoolBranch(String schoolBranch) {
		this.schoolBranch = schoolBranch;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

	public String getSchoolDivision() {
		return schoolDivision;
	}

	public void setSchoolDivision(String schoolDivision) {
		this.schoolDivision = schoolDivision;
	}

	public String getGrNumber() {
		return grNumber;
	}

	public void setGrNumber(String grNumber) {
		this.grNumber = grNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getRfidNumber() {
		return rfidNumber;
	}

	public void setRfidNumber(String rfidNumber) {
		this.rfidNumber = rfidNumber;
	}

	public String getParentNmae1() {
		return parentNmae1;
	}

	public void setParentNmae1(String parentNmae1) {
		this.parentNmae1 = parentNmae1;
	}

	public String getMobileNumber1() {
		return mobileNumber1;
	}

	public void setMobileNumber1(String mobileNumber1) {
		this.mobileNumber1 = mobileNumber1;
	}

	public String getParentNmae2() {
		return parentNmae2;
	}

	public void setParentNmae2(String parentNmae2) {
		this.parentNmae2 = parentNmae2;
	}

	public String getMobileNumber2() {
		return mobileNumber2;
	}

	public void setMobileNumber2(String mobileNumber2) {
		this.mobileNumber2 = mobileNumber2;
	}

	public LocalDateTime getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDateTime createddate) {
		this.createddate = createddate;
	}

	public String getCreateduserid() {
		return createduserid;
	}

	public void setCreateduserid(String createduserid) {
		this.createduserid = createduserid;
	}

	public boolean isParentSmsSend1() {
		return parentSmsSend1;
	}

	public void setParentSmsSend1(boolean parentSmsSend1) {
		this.parentSmsSend1 = parentSmsSend1;
	}

	public boolean isParentSmsSend2() {
		return parentSmsSend2;
	}

	public void setParentSmsSend2(boolean parentSmsSend2) {
		this.parentSmsSend2 = parentSmsSend2;
	}

	public boolean isParentAccess() {
		return parentAccess;
	}

	public void setParentAccess(boolean parentAccess) {
		this.parentAccess = parentAccess;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
