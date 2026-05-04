package com.example.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.loan.dto.LoanContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = { LoanContactInfoDto.class })
@OpenAPIDefinition(info = @Info(title = "Loans Microservice REST API Documentation", description = "CrazyBank Loans microservice REST API Documentation", version = "v1", contact = @Contact(name = "Vince", email = "example@crazybytes.com", url = "https://www.crazybytes.com"), license = @License(name = "Apache 2.0", url = "https://www.crazybytes.com")), externalDocs = @ExternalDocumentation(description = "CrazyBank Accounts microservice REST API Documentation", url = "http://localhost:8080/swagger-ui/index.html"))

public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
