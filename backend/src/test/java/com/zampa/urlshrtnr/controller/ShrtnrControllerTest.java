package com.zampa.urlshrtnr.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.not;

@WebMvcTest
@AutoConfigureMockMvc
class ShrtnrControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ShrtnrController controller;

    @Test
    public void givenBodyIsComplete_whenPostingURL_thenResponseStatusShouldBeCreated() throws Exception {
        String body = "{\"url\" : \"someURL\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.url", Is.is(not(nullValue()))));
    }

    @Test
    public void givenURLIsNull_whenPostingURL_thenExceptionShouldBeThrown() throws Exception {
        String body = "{\"url\" : \"\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.detail", Is.is("URL can't be null")));
    }
}