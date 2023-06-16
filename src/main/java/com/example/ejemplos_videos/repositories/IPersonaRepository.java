package com.example.ejemplos_videos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplos_videos.entities.Persona;

@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable> {

	public abstract Persona findByNombre(String nombre);

	public abstract Persona findByPaisAndEdad(String pais, int edad);

	public abstract Persona findByPaisAndEdadOrderByEdadDesc(String pais, int edad);

}
