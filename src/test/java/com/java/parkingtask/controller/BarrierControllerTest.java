package com.java.parkingtask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.parkingtask.model.CommandDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class BarrierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenBarrierIdIsNotExist() throws Exception{
        String url = "/barriers/6";
        this.mockMvc.perform(get(url))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Barrier Not Found")));
    }

    @Test
    void whenBarrierIdIsExist() throws Exception{
        String url = "/barriers/5";
        this.mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", Matchers.aMapWithSize(4)))
                .andExpect(jsonPath("$.id", Matchers.equalTo(5)))
                .andExpect(jsonPath("$.barrierName", Matchers.equalTo("Шлагбаум 5")))
                .andExpect(jsonPath("$.open", Matchers.equalTo(false)));
    }

    @Test
    void getAllBarriers() throws Exception{
        String url = "/barriers/";
        this.mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", Matchers.hasSize(5)))
                .andExpect(jsonPath("$[0].barrierName", Matchers.equalTo("Шлагбаум 1")))
                .andExpect(jsonPath("$[0].barrierType", Matchers.equalTo("in")));
    }

    @Test
    void openBarrier() throws Exception{
        String url = "/barriers/1";

        String command = "open";

        this.mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new CommandDTO(command))).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", Matchers.aMapWithSize(4)))
                .andExpect(jsonPath("$.open", Matchers.equalTo(true)));
    }

    @Test
    void closeBarrier() throws Exception{
        String url = "/barriers/2";

        String command = "close";

        this.mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new CommandDTO(command))).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", Matchers.aMapWithSize(4)))
                .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
                .andExpect(jsonPath("$.barrierName", Matchers.equalTo("Шлагбаум 2")))
                .andExpect(jsonPath("$.open", Matchers.equalTo(false)));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}