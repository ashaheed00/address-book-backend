package com.adbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adbk.dto.ContactDTO;
import com.adbk.dto.ResponseDTO;
import com.adbk.exception.AddressBookException;
import com.adbk.model.Contact;
import com.adbk.service.IContactDataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/address-book")
@Slf4j
public class ContactDataController {

	@Autowired
	IContactDataService contactDataService;

	@GetMapping("/contacts")
	public ResponseEntity<ResponseDTO> getAllContacts() {
		log.info("GET call to fetch all contacts");
		List<Contact> contactlist = contactDataService.getAllContacts();
		ResponseDTO response = new ResponseDTO("GET call successful", contactlist);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/contact/{contactId}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("contactId") Long contactId) {
		log.info("GET call to fetch contact with id: " + contactId);
		Contact contact = contactDataService.getContactById(contactId);
		ResponseDTO response = new ResponseDTO("GET Call Successful for Id : " + contactId, contact);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/contact/add")
	public ResponseEntity<ResponseDTO> addNewContact(@Valid @RequestBody ContactDTO contactDTO) {
		log.info("POST call to add new contact");
		Contact contact = contactDataService.addNewContact(contactDTO);
		ResponseDTO response = new ResponseDTO("POST Call Successful", contact);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/contact/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContactById(@Valid @PathVariable("contactId") Long contactId,
			@Valid @RequestBody ContactDTO contactDTO) {
		log.info("PUT call to update contact with id: " + contactId);
		Contact contact = contactDataService.updateContactById(contactId, contactDTO);
		ResponseDTO response = new ResponseDTO("PUT Call Successful", contact);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/contact/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable("contactId") Long contactId)
			throws AddressBookException {
		log.info("DELETE call to update contact with id: " + contactId);
		contactDataService.deleteContactById(contactId);
		ResponseDTO response = new ResponseDTO("DELETE Call Successful", "Deleted contact with id: " + contactId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

}
