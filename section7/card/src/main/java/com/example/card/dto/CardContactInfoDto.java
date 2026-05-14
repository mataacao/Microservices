package com.example.card.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "card")
@Getter
@Setter
@JsonPropertyOrder({"message", "contactDetails", "onCallSupport"})
public class CardContactInfoDto {

	private String message;
	private Map<String, String> contactDetails;
	private List<String> onCallSupport;
}
