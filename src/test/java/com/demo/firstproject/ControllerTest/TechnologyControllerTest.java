package com.demo.firstproject.ControllerTest;

import com.demo.firstproject.services.TechnologyService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import javax.ws.rs.core.MediaType;
import static com.demo.firstproject.testUtils.TestEntityFactory.createTechnologyModel;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 class TechnologyControllerTest extends  AbstractMVCTest{

    @MockBean
    TechnologyService technologyService;




    @Test
    void getTechnologyTest  () throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/technology"))
                .andExpect(status().isOk());

    }

    @Test
    void createTechnologyTest () throws Exception {
        technologyService.createTechnology(createTechnologyModel());
        verify(technologyService, times(1)).createTechnology(createTechnologyModel());
        String newTechnology = new Gson().toJson(createTechnologyModel());
        mockMvc.perform(MockMvcRequestBuilders.post("/technology")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTechnology))
                        .andExpect(status().isCreated());
    }

    @Test
     void updateTechnologyTest () throws Exception {

        technologyService.updateTechnology(1L, createTechnologyModel());
        verify(technologyService, times(1)).updateTechnology(1L, createTechnologyModel());
        String newTechnology = new Gson().toJson(createTechnologyModel());
        mockMvc.perform(MockMvcRequestBuilders.put("/technology/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTechnology))
                         .andExpect(status().isOk());
    }

    @Test
     void deleteTechnologyTest () throws Exception {

        technologyService.deleteTechnology(1L);
        verify(technologyService,times(1)).deleteTechnology(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/technology/1"))
                .andExpect((status().isOk()));
    }

     @Test
     void findTechnologyIdTest () throws Exception {

         mockMvc.perform(MockMvcRequestBuilders.get("/technology/1"))
                 .andExpect((status().isOk()));
     }
}
