package com.example.ejemplos_videos.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.ejemplos_videos.converters.PersonaConverter;
import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.repositories.IPersonaRepository;
import com.example.ejemplos_videos.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService {

	@Autowired @Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired @Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Override
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}

	@Override
	public PersonaModelo insertOrUpdate(PersonaModelo personaModelo) {
		
		Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModelo));
		
		return personaConverter.entityToModel(persona);
	}

	@Override
	public boolean remove(int id) {
		boolean res;
		try {
			res = true;
			personaRepository.deleteById(id);
		} catch (Exception e){
			res = false;
		}
		return res;
	}

}
