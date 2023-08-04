package com.fmera.jwt.backend.controllers;

import com.fmera.jwt.backend.model.Persona;
import com.fmera.jwt.backend.model.dtos.PersonaDTO;
import com.fmera.jwt.backend.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public List<Persona> listarPersonas() {
        return personaService.findAllPersonas();
    }

    @PostMapping("/personas")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @DeleteMapping("/personas/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }

    @GetMapping("/personas/{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.findPersonaById(id);
    }

    @PutMapping("/personas/update/{id}")
    public Persona actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.updatePersona(id, persona);
    }

    @PostMapping("/login")
    public PersonaDTO login(@RequestBody Persona persona) {
        return personaService.login(persona.getUser(), persona.getPassword());
    }
}
