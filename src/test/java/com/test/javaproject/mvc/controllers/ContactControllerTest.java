package com.test.javaproject.mvc.controllers;

import com.test.javaproject.mvc.repository.ContactRepository;
import com.test.javaproject.mvc.service.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Alexey on 14.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {

    @InjectMocks
    private ContactController contactController;

//    @Autowired
//    @Qualifier("contactServiceMock")
//    private ContactService contactServiceMock;
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(contactController).build();
    }

    @Test
    public void addContact() throws Exception {
        mockMvc.perform(get("/addContact"))
                .andExpect(status().isOk())
                .andExpect(view().name("contactRegistr"))
                .andExpect(forwardedUrl("contactRegistr"));
//                .andExpect(model().attribute("userDtoToLogin", userDto));
    }

}