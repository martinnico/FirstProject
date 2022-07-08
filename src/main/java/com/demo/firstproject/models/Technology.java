package com.demo.firstproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Technology")
public class Technology {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTechnology;

    @NotBlank
    @NotEmpty(message = "completar con nombre de tecnologia")
    private String nameTechnology;

    @NotBlank
    @NotEmpty(message = "completar con numero de version")
    private String version;

}
