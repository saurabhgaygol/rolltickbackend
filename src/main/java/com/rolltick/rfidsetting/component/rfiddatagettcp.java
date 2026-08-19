package com.rolltick.rfidsetting.component;


import java.nio.charset.StandardCharsets;


import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.rolltick.rfidsetting.service.rfidAttendanceRawDataSevice;

@Component
public class rfiddatagettcp {
    

	private final rfidAttendanceRawDataSevice rfidrawdata;
	
	public rfiddatagettcp (rfidAttendanceRawDataSevice rfidrawdata) 
	{
		this.rfidrawdata=rfidrawdata;
	}
	
	
	@ServiceActivator(inputChannel ="rfidInputChanal")
	public void resivedata(Message<?> message) {
		
		Object payload = message.getPayload();

        String rfidData;

        if (payload instanceof byte[]) {
            rfidData = new String((byte[]) payload, StandardCharsets.UTF_8);
        } else {
            rfidData = payload.toString();
        }

        System.out.println("================================");
        System.out.println("RFID DATA RECEIVED:");
        System.out.println(rfidData);
        rfidrawdata.saverawdata(rfidData);
        System.out.println("================================");
    
	}
	
}
