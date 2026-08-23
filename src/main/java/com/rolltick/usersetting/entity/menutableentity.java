package com.rolltick.usersetting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "menu_table")
public class menutableentity {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long Id;
	  
	  @NotBlank
	  @Column(name = "type_of_module")
	  private String TypeOfModule;
	  
	  @NotBlank
	  @Column(name = "menu_name")
	  private String MenuName;
	  
	  @Column(name = "parent_menu_id")
	  private Long ParentMenuId;
	  
	  @Column(name = "menu_path")
	  private String MenuPath;

	  @Column(name = "menu_icon")
	  private String MenuIcon;
	  
	  @Column(name = "display_order")
	  private Integer DisplayOrder;
	  
	  @Column(name = "status")
	  private String Status;
	  
	  
	  

	public String getTypeOfModule() {
		return TypeOfModule;
	}

	public void setTypeOfModule(String typeOfModule) {
		TypeOfModule = typeOfModule;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMenuName() {
		return MenuName;
	}

	public void setMenuName(String menuName) {
		MenuName = menuName;
	}

	public Long getParentMenuId() {
		return ParentMenuId;
	}

	public void setParentMenuId(Long parentMenuId) {
		ParentMenuId = parentMenuId;
	}

	public String getMenuPath() {
		return MenuPath;
	}

	public void setMenuPath(String menuPath) {
		MenuPath = menuPath;
	}

	public String getMenuIcon() {
		return MenuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		MenuIcon = menuIcon;
	}

	public Integer getDisplayOrder() {
		return DisplayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		DisplayOrder = displayOrder;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}


		

	}
