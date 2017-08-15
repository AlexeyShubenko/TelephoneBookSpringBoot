package com.test.javaproject.mvc.service.impl;

import com.test.javaproject.mvc.domains.Contact;
import com.test.javaproject.mvc.dto.ContactDto;
import com.test.javaproject.mvc.repository.ContactRepository;
import com.test.javaproject.mvc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepository;

	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public List<ContactDto> getContactList(Long userId) {
		List<Contact> allContacts = contactRepository.getContactList(userId);
		List<ContactDto> allContactsDto = new ArrayList<>();
		for (Contact contact:allContacts) {
			ContactDto contactDto = new ContactDto.Builder()
					.setContactId(contact)
					.setFirstName(contact)
					.setLastName(contact)
					.setMiddleName(contact)
					.setMobPhoneNumber(contact)
					.setHomePhoneNumber(contact)
					.setEmail(contact)
					.setAddress(contact)
					.build();
			allContactsDto.add(contactDto);
		}
		return allContactsDto;
	}

	@Override
	public void saveContact(Long userId, ContactDto contactDto) {
		Contact contact = new Contact.Builder()
				.setContactId(contactDto)
				.setFirstName(contactDto)
				.setLastName(contactDto)
				.setMiddleName(contactDto)
				.setMobPhoneNumber(contactDto)
				.setHomePhoneNumber(contactDto)
				.setEmail(contactDto)
				.setAddress(contactDto)
				.build();
		contactRepository.saveContact(userId, contact);
	}
	
	@Override
	public void editContact(ContactDto contactDto) {
		Contact contact = new Contact.Builder()
				.setContactId(contactDto)
				.setFirstName(contactDto)
				.setLastName(contactDto)
				.setMiddleName(contactDto)
				.setMobPhoneNumber(contactDto)
				.setHomePhoneNumber(contactDto)
				.setEmail(contactDto)
				.setAddress(contactDto)
				.build();
		contactRepository.editContact(contact);
	}
	
	@Override
	public ContactDto getContactById(Long contactId) {
		Contact contact = contactRepository.getOne(contactId);
		ContactDto contactDto = new ContactDto.Builder()
				.setContactId(contact)
				.setFirstName(contact)
				.setLastName(contact)
				.setMiddleName(contact)
				.setMobPhoneNumber(contact)
				.setHomePhoneNumber(contact)
				.setEmail(contact)
				.setAddress(contact)
				.build();
		return contactDto;
	}
	
	@Override
	public void deleteContact(Long contactId) {
		contactRepository.delete(contactId);
	}

	@Override
	public boolean checkExistingContact(Long userId, String mobPhoneNumber) {
		return contactRepository.checkExistingContact(userId, mobPhoneNumber);
	}
}
