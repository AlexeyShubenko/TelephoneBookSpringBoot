package com.test.javaproject.mvc.controllers;

import com.test.javaproject.mvc.dto.UserDto;
import com.test.javaproject.mvc.service.ContactService;
import com.test.javaproject.mvc.service.UserService;
import com.test.javaproject.mvc.service.impl.WorkService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by Alexey on 14.08.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = {TestContext.class, SpringApplicationContextLoader.class})
//@WebAppConfiguration
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;
    @Autowired
    @Qualifier("userServiceMock")
    private UserService serviceMock;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(loginController).build();
    }


    @Test
    public void startPageLog() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("startPage"))
                .andExpect(forwardedUrl("startPage"));
//                .andExpect(model().attribute("userDtoToLogin", userDto));
    }

//    @Test
//    public void checkLoginUserValidationFail() throws Exception {
//        UserDto userDto = new UserDto(null, "user1", "user1", "User User User");
//        String login = "user1";
//        String password = "user1";
//        String fio = "User User User";
//
//        when(serviceMock.verifyUser(isA(String.class),isA(String.class))).thenReturn(userDto);
//
//        mockMvc.perform(post("/checkLoginUser")
//                .param("loginName",login)
//                .param("password", password)
//                .param("fio", fio)
//        )
//                .andExpect(status().isOk())
////                .andExpect(flash().attribute("error","Input data is wrong!"))
////                .andExpect(view().name("redirect:/"))
//                .andExpect(forwardedUrl("redirect:/showContacts"))
//                .andExpect(model().attribute("userDto", hasProperty("loginName", is("user1"))))
//                .andExpect(model().attribute("userDto", hasProperty("password", is("user1"))))
//                .andExpect(model().attribute("userDto", hasProperty("fio", is("user1"))));;
//
//    }

}