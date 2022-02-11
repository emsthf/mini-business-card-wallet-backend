package com.mini.back.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.back.model.BusinessCard;
import com.mini.back.service.BusinessCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.BodyBuilder;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import javax.swing.text.AbstractDocument.Content;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class BusinessCardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessCardService businessCardService;

//    @Test
//    public void add() throws Exception {
//        BusinessCard businessCard = new BusinessCard(1L, "사장", "이재용", "010-0000-0000", "samsung@gmail.com");
//        String content = new ObjectMapper().writeValueAsString(businessCard);
//        when(businessCardService.addCard(businessCard)).thenReturn(new BusinessCard(1L, "사장", "이재용", "010-0000-0000", "samsung@gmail.com"));
//
//        ResultActions resultActions = mockMvc.perform(post("/api/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content)
//                .accept(MediaType.APPLICATION_JSON));
//
//        resultAction
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.title").value("test"))
//                 .andDo(print());
//    }

    @Test
    void edit() {
    }

    @Test
    void getAll() throws Exception {
        // given
        List<BusinessCard> cards = new ArrayList<>();
        cards.add(new BusinessCard(1L, "사장", "minwoo", "010-0000-0000", "dd@gmail.com"));
        cards.add(new BusinessCard(2L, "test2", "재용", "010-1111-1111", "qq11@gmail.com"));
        when(businessCardService).thenReturn((BusinessCardService) cards);
        // when
        ResultActions resultAction = mockMvc.perform( get("/api/getAll")
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultAction
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.[0].position").value("사장"))
                .andExpect(jsonPath("$.[0].name").value("minwoo"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void del() {

    }
}