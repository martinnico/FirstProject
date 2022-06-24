package com.demo.firstproject.ControllerTest;

import com.demo.firstproject.services.CandidateXTechnologyService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;

import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateDto;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateXTEchnologyModel;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CandidateXTechnologyControllerTest extends AbstractMVCTest{

    @MockBean
    CandidateXTechnologyService candidateXTechnologyService;

    @Test
        void getCandidateXTechnologyTest () throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/candidateXTechnology"))
                    .andExpect(status().isOk());
        }

    @Test
    void createCandidateXTechnologyTest () throws Exception {

        candidateXTechnologyService.createCandidateXTechnology(createCandidateXTEchnologyModel());
        verify(candidateXTechnologyService, times(1)).createCandidateXTechnology(createCandidateXTEchnologyModel());
        String newCandidateXTechnology = new Gson().toJson(createCandidateXTEchnologyModel());
        mockMvc.perform(MockMvcRequestBuilders.post("/candidateXTechnology")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCandidateXTechnology))
                        .andExpect(status().isCreated());
    }

    @Test
    void updateCandidateXTechnologyTest () throws Exception {

        candidateXTechnologyService.updateCandidateXTechnology(1L,createCandidateXTEchnologyModel());
        verify(candidateXTechnologyService,times(1)).updateCandidateXTechnology(1L,createCandidateXTEchnologyModel());
        String newCandidateXTechnology = new Gson().toJson(createCandidateDto());
        mockMvc.perform(MockMvcRequestBuilders.put("/candidateXTechnology/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCandidateXTechnology))
                        .andExpect(status().isOk());

    }

    @Test
    void deleteCandidateXTechnologyTest () throws Exception {

        candidateXTechnologyService.deleteCandidateXTechnology(1L);
        verify(candidateXTechnologyService, times(1)).deleteCandidateXTechnology(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/candidateXTechnology/1"))
                .andExpect((status().isOk()));
    }

    @Test
    void findCandidateXTechnologyIdTest () throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/dto/1"))
                .andExpect((status().isOk()));
    }
}


