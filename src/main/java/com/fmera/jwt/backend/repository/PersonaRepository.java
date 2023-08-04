package com.fmera.jwt.backend.repository;

import com.fmera.jwt.backend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    //buscar por user y password
    Persona findByUserAndPassword(String user, String password);
}
