package com.rolltick.rfidsetting.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory;
import org.springframework.integration.ip.tcp.inbound.TcpInboundGateway;
import org.springframework.integration.ip.tcp.serializer.ByteArrayCrLfSerializer;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import tools.jackson.core.util.JsonRecyclerPools.ThreadLocalPool;

@Configuration
public class rfidconfigtcp {
	
	@Value("${rfid.tcp.port}")
	private int rfidport;

	
	@Bean
	public AbstractServerConnectionFactory tcprfidserver()
	{
		TcpNetServerConnectionFactory server =
                new TcpNetServerConnectionFactory(rfidport);
		ByteArrayCrLfSerializer serializer = new ByteArrayCrLfSerializer();

	    server.setSerializer(serializer);
	    server.setDeserializer(serializer);
		
		return server;
	}
	
	/*@Bean
    public MessageChannel rfidInputChanal() {
        return new DirectChannel();
    }*/
	
	 @Bean
	    public TcpInboundGateway rfidTcpInboundGateway(
	            AbstractServerConnectionFactory tcpRfidServer,
	            MessageChannel rfidInputChanal) {

	        TcpInboundGateway gateway = new TcpInboundGateway();

	        gateway.setConnectionFactory(tcpRfidServer);
	        gateway.setRequestChannel(rfidInputChanal);

	        return gateway;
	    }
	
	 @Bean
		public MessageChannel rfidInputChanal() 
		{
			ThreadPoolTaskExecutor excuter=new ThreadPoolTaskExecutor();
			
			excuter.setCorePoolSize(20);
			excuter.setMaxPoolSize(50);
			excuter.setQueueCapacity(5000);
			excuter.setThreadNamePrefix("RFID-");
			excuter.initialize();
			return new ExecutorChannel(excuter);
		}
		
	 
	
}
