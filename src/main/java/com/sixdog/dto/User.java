package com.sixdog.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Validated
public class User {
	
	
	@Getter
	@Setter
//	@NotNull
//	@Size(min=2,max=10)
	@NotBlank(message = "{user.name.notBlank}")
	private String name;
	
}
