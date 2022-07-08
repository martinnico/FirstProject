package com.demo.firstproject.Controller;

import com.demo.firstproject.services.TechnologyService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;

import static com.demo.firstproject.testUtils.TestEntityFactory.createTechnologyDto;
import static com.demo.firstproject.testUtils.TestEntityFactory.createTechnologyModel;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TechnologyControllerTest extends AbstractMVCTest {

    @MockBean
    TechnologyService technologyService;

    @Test
    void getTechnologyTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/technology")
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(new HttpHeaders()))
                .andExpect(status().isOk());

    }

    @Test
    void createTechnologyTest() throws Exception {
        technologyService.createTechnology(createTechnologyDto());
        verify(technologyService, times(1)).createTechnology(createTechnologyDto());
        String newTechnology = new Gson().toJson(createTechnologyModel());
        mockMvc.perform(MockMvcRequestBuilders.post("/technology")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTechnology))
                .andExpect(status().isCreated());
    }

    @Test
    void updateTechnologyTest() throws Exception {

        technologyService.updateTechnology(1L, createTechnologyDto());
        verify(technologyService, times(1)).updateTechnology(1L, createTechnologyDto());
        String newTechnology = new Gson().toJson(createTechnologyModel());
        mockMvc.perform(MockMvcRequestBuilders.put("/technology/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTechnology))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTechnologyTest() throws Exception {

        technologyService.deleteTechnology(1L);
        verify(technologyService, times(1)).deleteTechnology(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/technology/1"))
                .andExpect((status().isOk()));
    }

    @Test
    void findTechnologyIdTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/technology/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(new HttpHeaders()))
                .andExpect((status().isOk()));
    }
}
