package com.example.ejemplos_videos.services;

import java.util.List;

import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.PersonaModelo;

public interface IPersonaService {
	
	public List<Persona> getAll();
	
	public PersonaModelo insertOrUpdate(PersonaModelo personaModelo);
	
	public boolean remove(int id);
}
