package com.adbk.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor class ContactDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}\\s?([A-Z]{1}[a-z]{1,}\\s?){0,2}$", message = "Please enter name in correct format. Eg. John Smith")
	private String name;

	@NotBlank(message = "Please enter address")
	private String address;
	@NotBlank(message = "Please enter state")
	private String state;
	@NotBlank(message = "Please enter city")
	private String city;

	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Wrong Zip Code format. Eg. 654321")
	private String zip;

	private String phoneNo;

	private String email;
}
