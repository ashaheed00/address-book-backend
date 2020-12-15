package com.adbk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.adbk.dto.ContactDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address_book")
public @Data @NoArgsConstructor class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private long id;

	private String name;
	private String address;
	private String state;
	private String city;
	private String zip;
	private String phoneNo;
	private String email;

	public Contact(long id, String name, String address, String state, String city, String zip, String phoneNo,
			String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public Contact(ContactDTO contactDTO) {
		this.name = contactDTO.getName();
		this.address = contactDTO.getAddress();
		this.state = contactDTO.getState();
		this.city = contactDTO.getCity();
		this.zip = contactDTO.getZip();
		this.phoneNo = contactDTO.getPhoneNo();
		this.email = contactDTO.getEmail();
	}

	public Contact(Long id, ContactDTO contactDTO) {
		this(contactDTO);
		this.id = id;
	}

}
