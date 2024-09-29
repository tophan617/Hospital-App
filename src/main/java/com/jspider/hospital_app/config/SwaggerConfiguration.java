package com.jspider.hospital_app.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {
	@Bean
	public OpenAPI swagger() {
		Server server=new Server();
		server.setUrl("http://localhost:8080/hospital_app");
		server.setDescription("Hospital-app");
		
		Contact contact=new Contact();
		contact.setName("Tophan Giri");
		contact.setEmail("tophangiri036@gmail.com");
		contact.setUrl("http://localhost:8080/hospital_app");
		
		License license=new License();
		license.setName("MSI");
		license.setUrl("MSI-License");
		
		Info info=new Info();
		info.setContact(contact);
		info.setDescription("Apollo Hospital");
		info.setSummary("very good hospital");
		info.setVersion("1.0");
		return new OpenAPI().info(info).servers(List.of(server));
		
	}
}
