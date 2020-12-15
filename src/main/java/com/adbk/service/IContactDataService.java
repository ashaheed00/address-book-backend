package com.adbk.service;

import java.util.List;

import com.adbk.dto.ContactDTO;
import com.adbk.model.Contact;

public interface IContactDataService {

	List<Contact> getAllContacts();

	Contact getContactById(Long contactId);

	Contact addNewContact(ContactDTO contactDto);

	Contact updateContactById(Long contactId, ContactDTO contactDto);

	void deleteContactById(Long contactId);

}
