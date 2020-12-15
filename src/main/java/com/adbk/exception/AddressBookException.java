package com.adbk.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor @AllArgsConstructor class AddressBookException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

}
