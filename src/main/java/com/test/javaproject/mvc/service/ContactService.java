package com.test.javaproject.mvc.service;

import com.test.javaproject.mvc.domains.Contact;
import com.test.javaproject.mvc.dto.ContactDto;

import java.util.List;

public interface ContactService {

	List<ContactDto> getContactList(Long userId);
	void saveContact(Long userId, ContactDto contactDto);
	void deleteContact(Long contactId);
	ContactDto getContactById(Long contactId);
	void editContact(ContactDto contactDto);
    boolean checkExistingContact(Long userId, String mobPhoneNumber);
}
