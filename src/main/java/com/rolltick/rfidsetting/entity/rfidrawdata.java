package com.rolltick.rfidsetting.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rfid_rawdata")
public class rfidrawdata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="orgId")
    private String orgId;
	
	@Column(name="machine_id")
	private String machineId;
	
	
	@Column(name="transaction_datetime")
	private LocalDateTime transactionDatetime;
	
	@Column(name="save_time")
	private LocalDateTime saveTime;
	
	@Column(name="all_data")
	private String alldata;
	
	
	
	

	public String getAlldata() {
		return alldata;
	}

	public void setAlldata(String alldata) {
		this.alldata = alldata;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public LocalDateTime getTransactionDatetime() {
		return transactionDatetime;
	}

	public void setTransactionDatetime(LocalDateTime transactionDatetime) {
		this.transactionDatetime = transactionDatetime;
	}

	public LocalDateTime getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(LocalDateTime saveTime) {
		this.saveTime = saveTime;
	}
	
	
	
	
}
