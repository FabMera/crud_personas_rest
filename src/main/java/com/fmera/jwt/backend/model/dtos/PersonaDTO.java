package com.fmera.jwt.backend.model.dtos;

import jakarta.persistence.Basic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonaDTO {

    Long id;
    String ubication;
    String position;
    String fullName;
    String image;

    public PersonaDTO() {
    }

}
