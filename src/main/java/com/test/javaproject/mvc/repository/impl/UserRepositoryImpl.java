package com.test.javaproject.mvc.repository.impl;

import com.test.javaproject.mvc.domains.User;
import com.test.javaproject.mvc.repository.UserRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alexey on 11.08.2017.
 */
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
}
