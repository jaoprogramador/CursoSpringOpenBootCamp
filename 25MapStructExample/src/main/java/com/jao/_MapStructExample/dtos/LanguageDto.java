package com.jao._MapStructExample.dtos;
import lombok.Data;

@Data
public class LanguageDto {
	private String name;
	private Boolean isOfficialLanguage;
	private Integer speakersTotal;
}