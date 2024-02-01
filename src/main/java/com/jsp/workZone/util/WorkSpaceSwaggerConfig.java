package com.jsp.workZone.util;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WorkSpaceSwaggerConfig {
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("jspider", "jsprider.com", "jspiders@yopmail.com");

		List<VendorExtension> extensions = new ArrayList<VendorExtension>();

		ApiInfo apiInfo = new ApiInfo("WORK ZONE",
				"The admin building client manager enables remote monitoring, managing, and support for your clients' buildings. get notified in real-time when there is a problem with a client's building, and offer support through the built-in chat interface or phone line.\r\n"
						+ "\r\n" + "",
				"1.0", "trems&condition", contact, "licince", "licince.url", extensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jsp.workZone")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}
