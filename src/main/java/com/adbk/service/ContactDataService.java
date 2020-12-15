package com.adbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbk.dto.ContactDTO;
import com.adbk.exception.AddressBookException;
import com.adbk.model.Contact;
import com.adbk.repository.ContactDataRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactDataService implements IContactDataService {

	@Autowired
	ContactDataRepository contactDataRepository;

	@Override
	public List<Contact> getAllContacts() {
		log.info("Fetching all Contacts data");
		return contactDataRepository.findAll();
	}

	@Override
	public Contact getContactById(Long contactId) {
		log.info("Fetching Contact data for id: " + contactId);
		return contactDataRepository.findById(contactId)
				.orElseThrow(() -> new AddressBookException("No Contact found with id: " + contactId));
	}

	@Override
	public Contact addNewContact(ContactDTO contactDTO) {
		log.info("New Contact is being added");
		Contact contact = new Contact(contactDTO);
		contactDataRepository.save(contact);
		return contact;
	}

	@Override
	public Contact updateContactById(Long contactId, ContactDTO contactDTO) {
		log.info("Updating Contact with id: " + contactId);
		if (!contactDataRepository.existsById(contactId))
			throw new AddressBookException("No Contact found with id: " + contactId);
		Contact contact = new Contact(contactId, contactDTO);
		return contactDataRepository.save(contact);
	}

	@Override
	public void deleteContactById(Long contactId) {
		log.info("Deleting Contact with id: " + contactId);
		if (!contactDataRepository.existsById(contactId))
			throw new AddressBookException("No Contact found with id: " + contactId);
		contactDataRepository.deleteById(contactId);
	}

}
