package com.demo.firstproject.ControllerTest;
import com.demo.firstproject.services.CandidateService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import javax.ws.rs.core.MediaType;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateDto;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CandidateControllerTest extends AbstractMVCTest {

    @MockBean
    CandidateService candidateService;


    @Test
    void getCandidateXTechnologyTest () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/candidate"))
                .andExpect(status().isOk());
    }

    @Test
    void createCandidateXTechnologyTest () throws Exception {

        candidateService.createCandidate(createCandidateDto());
        verify(candidateService, times(1)).createCandidate(createCandidateDto());
        String newCandidate = new Gson().toJson(createCandidateDto());
        mockMvc.perform(MockMvcRequestBuilders.post("/candidate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newCandidate))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCandidateXTechnologyTest () throws Exception {

        candidateService.updateCandidate(1L,createCandidateDto());
        verify(candidateService,times(1)).updateCandidate(1L,createCandidateDto());
        String newCandidate = new Gson().toJson(createCandidateDto());
        mockMvc.perform(MockMvcRequestBuilders.put("/candidate/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newCandidate))
                .andExpect(status().isOk());

    }

    @Test
    void deleteCandidateXTechnologyTest () throws Exception {

        candidateService.deleteCandidate(1L);
        verify(candidateService,times(1)).deleteCandidate(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/candidate/1"))
                .andExpect((status().isOk()));

    }

    @Test
    void findCandidateXTechnologyDto () throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/candidate/1"))
                .andExpect((status().isOk()));
    }
}

