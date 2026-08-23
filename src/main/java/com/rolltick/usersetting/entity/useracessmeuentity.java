package com.rolltick.usersetting.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;


@Entity
@Table(name = "user_menu_access")
public class useracessmeuentity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    
    @Column(name = "user_id", nullable = false)
    private String UserId;
    
    

    public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	@Column(name = "menu_id", nullable = false)
    private Long MenuId;

    @Column(name = "no_access")
    private Boolean NoAccess = false;

    @Column(name = "view")
    private Boolean View = false;

    @Column(name = "modify")
    private Boolean Modify = false;

    @Column(name = "add_delete")
    private Boolean AddDelete = false;

    @Column(name = "customize")
    private Boolean Customize = false;
    
    @ManyToOne
    @JoinColumn(
        name = "user_uniq_id",
        referencedColumnName = "user_uniq_id"
    )
    private usertableentity User;
    
    
    

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public Long getMenuId() {
		return MenuId;
	}

	public void setMenuId(Long menuId) {
		MenuId = menuId;
	}

	public Boolean getNoAccess() {
		return NoAccess;
	}

	public void setNoAccess(Boolean noAccess) {
		NoAccess = noAccess;
	}

	public Boolean getView() {
		return View;
	}

	public void setView(Boolean view) {
		View = view;
	}

	public Boolean getModify() {
		return Modify;
	}

	public void setModify(Boolean modify) {
		Modify = modify;
	}

	public Boolean getAddDelete() {
		return AddDelete;
	}

	public void setAddDelete(Boolean addDelete) {
		AddDelete = addDelete;
	}

	public Boolean getCustomize() {
		return Customize;
	}

	public void setCustomize(Boolean customize) {
		Customize = customize;
	}
    
    
    
    
    
    
	
}