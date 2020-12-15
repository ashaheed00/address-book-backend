package com.adbk.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor class ContactDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}\\s?([A-Z]{1}[a-z]{1,}\\s?){0,2}$", message = "Please enter name in correct format. Eg. John Smith")
	private String name;

	@Pattern(regexp = "^\\w[\\w\\s/,-]{3,}$", message = "Please enter address properly")
	private String address;
	@Pattern(regexp = "^[A-Z]{1}[a-z]{3,}$", message = "Please enter state properly")
	private String state;
	@Pattern(regexp = "^[A-Z]{1}[a-z]{3,}$", message = "Please enter city properly")
	private String city;

	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Wrong Zip Code format. Eg. 654321")
	private String zip;

	@Pattern(regexp = "^(\\+?91)?\\s?[0-9]{5}\\s?[0-9]{5}$", message = "Wrong Phone Number Format. Eg. 9009009001, 919009009001, +919009009001, +91 9009009001")
	private String phoneNo;

	@Pattern(regexp = "^[a-z][0-9a-z_+-]*\\.?[0-9a-z_+-]+@\\w+(\\.[a-z]{2,}){1,2}$", message = "Wrong email format is given. Eg. abc.def@email.co.in")
	private String email;
}
