package com.demo.firstproject.models.dto;

import com.demo.firstproject.models.Candidate;
import com.demo.firstproject.models.Technology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateXTechnologyDto {
    private Long id;
    private Candidate candidate;
    private Technology technology;
    private String experience;

}