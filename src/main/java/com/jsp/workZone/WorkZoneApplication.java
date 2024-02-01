package com.jsp.workZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WorkZoneApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(WorkZoneApplication.class, args);
	}
	
	public class WebConfig implements WebMvcConfigurer{
		public void addCorsMapping (CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE");
			
			
		}
	}

}
