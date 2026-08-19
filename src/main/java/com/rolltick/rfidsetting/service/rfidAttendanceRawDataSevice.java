package com.rolltick.rfidsetting.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolltick.rfidsetting.entity.rfidAttendance;
import com.rolltick.rfidsetting.entity.rfidrawdata;
import com.rolltick.rfidsetting.repo.rfidAttendanceRepository;
import com.rolltick.rfidsetting.repo.rfidRawDataRepository;

@Service
public class rfidAttendanceRawDataSevice {
	

	private rfidAttendanceRepository rfidattendancerepository;
	

	private final rfidRawDataRepository rfidrawdatarepository;
	
	public rfidAttendanceRawDataSevice(rfidAttendanceRepository rfidattendancerepository,rfidRawDataRepository rfidrawdatarepository) 
	{
		this.rfidattendancerepository= rfidattendancerepository;	
		this.rfidrawdatarepository= rfidrawdatarepository;
	}
	
	public void saverawdata(String rawdata) 
	{	
		    savedatainrawdata(rawdata);
		    saveclinerfiddata(rawdata);

	}
	
	
	public void savedatainrawdata(String dataraw) 
	{
      rfidrawdata dataget=new rfidrawdata();
		
		dataget.setOrgId(dataraw.substring(1, 6));
		dataget.setMachineId(dataraw.substring(7, 9));
		dataget.setSaveTime(LocalDateTime.now());
		
		dataget.setAlldata(dataraw);
		dataget.setTransactionDatetime(
			    LocalDateTime.parse(
			    		dataraw.substring(dataraw.length() - 15, dataraw.length() - 1),
			        DateTimeFormatter.ofPattern("ddMMyyyyHHmmss")
			    )
			);
		
		rfidrawdatarepository.save(dataget);
		
		System.out.println("get coect rfid data"+ " "+ dataget);
	}
	
	
	public void saveclinerfiddata(String dataraw) 
	{
		String clinedata=dataraw.substring(1, dataraw.length()-1);
		
		System.out.println("datacome"+clinedata);
		
		String[] partdata=clinedata.split("&",3);
		
		String fist=partdata[0];
		String secound=partdata[1];
		String rfid=partdata[2];
		
		System.out.println("datacome2"+fist+" "+secound+" "+rfid);
		String[] spliterfid=rfid.split(",");
		DateTimeFormatter format= DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		
		for(String reco: spliterfid) 
		{
			String[] maindatarfid=reco.split("&");
			
			String rfidcline=maindatarfid[0];
			String rfiddivicedatatime=maindatarfid[1];
			
			LocalDateTime devicetime=LocalDateTime.parse(rfiddivicedatatime,format);
			
			rfidAttendance saveformateddata=new rfidAttendance();
			
			saveformateddata.setOrgId(fist);
			saveformateddata.setMachineId(secound);
			saveformateddata.setRfid(rfidcline);
			saveformateddata.setTransactionDatetime(devicetime);
			saveformateddata.setSaveTime(LocalDateTime.now());
			
			rfidattendancerepository.save(saveformateddata);
			
			
			
		}
		
		
		
		
		
	}

}
