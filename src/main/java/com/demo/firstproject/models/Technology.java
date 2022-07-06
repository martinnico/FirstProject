
package com.demo.firstproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Technology")
public class Technology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTechnology;
    
    @NotEmpty(message = "completar con nombre de tecnologia")
    private String nameTechnology;
    
    @NotEmpty(message = "completar con numero de version")
    private String version;
    
}
