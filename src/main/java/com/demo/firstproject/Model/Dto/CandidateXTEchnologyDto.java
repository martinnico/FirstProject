package com.demo.firstproject.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateXTEchnologyDto {
    private String name;
    private String nameTechnology;
    private String experience;

}
