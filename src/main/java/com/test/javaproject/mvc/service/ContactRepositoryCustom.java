package com.test.javaproject.mvc.service;

import com.test.javaproject.mvc.domains.Contact;

/**
 * Created by Alexey on 11.08.2017.
 */
public interface ContactRepositoryCustom {

    void saveContact(Long userId, Contact contact);
    void editContact(Contact contact);
    boolean checkExistingContact(Long userId, String mobPhoneNumber);

}
