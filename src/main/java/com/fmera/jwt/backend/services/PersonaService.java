package com.fmera.jwt.backend.services;

import com.fmera.jwt.backend.model.Persona;
import com.fmera.jwt.backend.model.dtos.PersonaDTO;

import java.util.List;

public interface PersonaService {

    public List<Persona> findAllPersonas();

    public Persona savePersona(Persona persona);

    public void deletePersona(Long id);

    public Persona findPersonaById(Long id);

    public Persona updatePersona(Long id, Persona persona);

    public PersonaDTO login(String user, String password);

}
