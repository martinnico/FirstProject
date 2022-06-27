package com.demo.firstproject.models.dto;

import com.demo.firstproject.models.CandidateModel;
import com.demo.firstproject.models.TechnologyModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateXTechnologyDtoSend {
    private Long id;
    private CandidateModel candidate;
    private TechnologyModel technology;
    private String experience;
}
