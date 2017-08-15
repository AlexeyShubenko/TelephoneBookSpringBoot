package com.test.javaproject.mvc.repository;

import com.test.javaproject.mvc.domains.Contact;
import com.test.javaproject.mvc.dto.ContactDto;
import com.test.javaproject.mvc.service.ContactRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexey on 11.08.2017.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, ContactRepositoryCustom{

    @Query("select c from Contact c where c.user.userId=:userId")
    List<Contact> getContactList(@Param("userId") Long userId);

}
