package com.rolltick.usersetting.entity;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="user_table_entity")
public class usertableentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank
	@Column(name="reseller")
	private String Reseller;
	
	@NotBlank
	@Column(name="user_name")
	private String UserName;
	
	@NotBlank
	@Column(name="user_branch")
	private String UserBranch;
	
	@NotBlank
	@Column(name="user_id", unique = true)
	private String UserId;
	
	@NotBlank
	@Column(name="user_password")
	private String UserPassword;
	
	
	@Column(name="country")
	private String Country;
	
	@NotBlank
	@Column(name="state")
	private String State;
	
	
	@Column(name="city")
	private String City;
	
	
	@Column(name="zip_code")
	private String ZipCode;
	
	@Column(name="street_1")
	private String Street1;
	
	@Column(name="street_2")
	private String Street2;
	
	@Column(name="contact_person")
	private String ContactPerson;
	
	@Column(name="mobile_number")
	private String MobileNumber;
	
	@Column(name="whatsapp_number")
	private String WhatsAppNumber;
	
	@Column(name="helpdeskemail")
	private String HelpDeskEmail;
	
	@Column(name="time_zone")
	private String TimeZone;
	
	@Column(name="user_status")
	private String UserStatus;
	
	@Column(name="created_date")
	private String CreatedDate;
	
	@Column(name="created_user")
	private String CreatedUser;
	
	

	@UuidGenerator
	@Column(name = "user_uniq_id", unique = true, nullable = false)
	private String userUniqId;
	
	@Column(name = "user_role")
	private String UserRole;

	@Column(name = "parent_user_id")
	private String ParentUserId;
	
	
	
	
	@OneToMany(
		    mappedBy = "User",
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
		private List<useracessmeuentity> MenuAccess;
	
	
	
	
	
	

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getParentUserId() {
		return ParentUserId;
	}

	public void setParentUserId(String parentUserId) {
		ParentUserId = parentUserId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getReseller() {
		return Reseller;
	}

	public void setReseller(String reseller) {
		Reseller = reseller;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserBranch() {
		return UserBranch;
	}

	public void setUserBranch(String userBranch) {
		UserBranch = userBranch;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getStreet1() {
		return Street1;
	}

	public void setStreet1(String street1) {
		Street1 = street1;
	}

	public String getStreet2() {
		return Street2;
	}

	public void setStreet2(String street2) {
		Street2 = street2;
	}

	public String getContactPerson() {
		return ContactPerson;
	}

	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getWhatsAppNumber() {
		return WhatsAppNumber;
	}

	public void setWhatsAppNumber(String whatsAppNumber) {
		WhatsAppNumber = whatsAppNumber;
	}

	public String getHelpDeskEmail() {
		return HelpDeskEmail;
	}

	public void setHelpDeskEmail(String helpDeskEmail) {
		HelpDeskEmail = helpDeskEmail;
	}

	public String getTimeZone() {
		return TimeZone;
	}

	public void setTimeZone(String timeZone) {
		TimeZone = timeZone;
	}

	public String getUserStatus() {
		return UserStatus;
	}

	public void setUserStatus(String userStatus) {
		UserStatus = userStatus;
	}

	public String getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}

	public String getCreatedUser() {
		return CreatedUser;
	}

	public void setCreatedUser(String createdUser) {
		CreatedUser = createdUser;
	}
	
	
	
	public String getUserUniqId() {
		return userUniqId;
	}

	public void setUserUniqId(String userUniqId) {
		this.userUniqId = userUniqId;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
