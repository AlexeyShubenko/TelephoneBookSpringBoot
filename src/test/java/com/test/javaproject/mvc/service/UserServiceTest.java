package com.test.javaproject.mvc.service;

import com.test.javaproject.mvc.dto.UserDto;
import com.test.javaproject.mvc.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Alexey on 15.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Mock
    private UserServiceImpl userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void checkExistingUser() throws Exception {
        when(userService.checkExistingUser("user1")).thenReturn(true);
        boolean isExist = userService.checkExistingUser("user1");

        assertEquals(true, isExist);
    }

    @Test
    public void saveUser() throws Exception {
        UserDto userDto = new UserDto("user1","user1", "User1 User1");

        userService.saveUser(userDto);
        verify(userService, times(1)).saveUser(userDto);
    }

    @Test
    public void verifyUser() throws Exception {
        UserDto userDto = new UserDto("user1","user1", "User1 User1");
        when(userService.verifyUser("user1", "user1")).thenReturn(userDto);
        UserDto result = userService.verifyUser("user1", "user1");

        assertEquals("user1", result.getLoginName());
        assertEquals("user1", result.getPassword());
        assertEquals("User1 User1", result.getFio());
    }

}