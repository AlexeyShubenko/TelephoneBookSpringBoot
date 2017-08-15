package com.test.javaproject.mvc.repository.impl;

import com.test.javaproject.mvc.domains.Contact;
import com.test.javaproject.mvc.domains.User;
import com.test.javaproject.mvc.repository.UserRepository;
import com.test.javaproject.mvc.service.ContactRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Alexey on 11.08.2017.
 */
@Repository
public class ContactRepositoryImpl implements ContactRepositoryCustom {


    private UserRepository userRepository;

    @Autowired
    public ContactRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveContact(Long userId, Contact contact) {
        User user = userRepository.getOne(userId);
        contact.setUser(user);
        entityManager.persist(contact);
        entityManager.flush();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void editContact(Contact contact) {

        Contact oldContact = entityManager.createQuery("from Contact where contactId=:contactId",Contact.class)
                .setParameter("contactId", contact.getContactId())
                .getSingleResult();
        oldContact.setFirstName(contact.getFirstName());
        oldContact.setLastName(contact.getLastName());
        oldContact.setMiddleName(contact.getMiddleName());
        oldContact.setMobPhoneNumber(contact.getMobPhoneNumber());
        oldContact.setHomePhoneNumber(contact.getHomePhoneNumber());
        oldContact.setAddress(contact.getAddress());
        oldContact.setEmail(contact.getEmail());
        entityManager.persist(oldContact);
//        entityManager.refresh(oldContact);
        entityManager.flush();
    }

    @Override
    public boolean checkExistingContact(Long userId, String mobPhoneNumber) {
         List<Contact> contacts = entityManager.createQuery("from Contact c where c.user.userId = :userId and c.mobPhoneNumber=:mobPhoneNumber", Contact.class)
                .setParameter("userId",userId)
                .setParameter("mobPhoneNumber", mobPhoneNumber)
                .getResultList();
        return contacts.size()>0?true:false;
    }
}
