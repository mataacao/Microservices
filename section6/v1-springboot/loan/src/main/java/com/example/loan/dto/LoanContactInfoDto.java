package com.example.loan.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "loan")
public record LoanContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {

}
