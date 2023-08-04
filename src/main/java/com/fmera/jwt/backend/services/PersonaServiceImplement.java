package com.fmera.jwt.backend.services;

import com.fmera.jwt.backend.model.Persona;
import com.fmera.jwt.backend.model.dtos.PersonaDTO;
import com.fmera.jwt.backend.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImplement implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAllPersonas() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona updatePersona(Long id, Persona persona) {
        Persona personaActual = personaRepository.findById(id).orElse(null);
        personaActual.setUbication(persona.getUbication());
        personaActual.setFullName(persona.getFullName());
        personaActual.setPosition(persona.getPosition());
        return personaRepository.save(personaActual);
    }

    @Transactional
    public PersonaDTO login(String user, String password) {
        Persona persona = personaRepository.findByUserAndPassword(user, password);
        PersonaDTO personaDTO = new PersonaDTO(persona.getId(),persona.getUbication(),persona.getPosition(),persona.getFullName(),persona.getImage());
        return personaDTO;
    }

}
