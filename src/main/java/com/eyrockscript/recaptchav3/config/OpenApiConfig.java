package com.eyrockscript.recaptchav3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().addServersItem(new Server().url("http://localhost:8080")).components(new Components())
		.info(new Info().title("Simple").version("V1")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")))
		.addServersItem(new Server().url("http://localhost:8080"))
				.info(new Info().title("Simple Service").version("V1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
	
}
