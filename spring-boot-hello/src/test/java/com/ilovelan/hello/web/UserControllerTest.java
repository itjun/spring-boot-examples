package com.ilovelan.hello.web;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class UserControllerTest {

    private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testGetUser() throws UnsupportedEncodingException, Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/getUser")).andReturn().getResponse()
                .getContentAsString();
        log.info("result = {}", responseString);
    }

}
