package com.leysoft.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.leysoft.client.AutorClient;

@Configuration
public class SoapConfiguration {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.leysoft.ws.autor");
		return marshaller;
	}
	
	@Bean
	public AutorClient autorClient(Jaxb2Marshaller marshaller) {
		AutorClient client = new AutorClient();
		client.setDefaultUri("http://localhost:8888/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}