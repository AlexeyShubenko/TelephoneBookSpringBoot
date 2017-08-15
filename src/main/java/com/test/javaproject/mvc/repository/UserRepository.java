package com.test.javaproject.mvc.repository;

import com.test.javaproject.mvc.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Alexey on 10.08.2017.
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    @Query("select u from User u where u.loginName=:loginName")
    User getUserByLoginName(@Param("loginName") String login);

}
