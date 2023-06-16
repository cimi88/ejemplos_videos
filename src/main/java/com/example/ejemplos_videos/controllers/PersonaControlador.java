package com.example.ejemplos_videos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_videos.helpers.ViewRouteHelper;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.services.IPersonaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("personas")
public class PersonaControlador{
	
	@Autowired @Qualifier("personaService")
	private IPersonaService personaService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/crearPersona")
	public ModelAndView crearPersona(Model model) {
		model.addAttribute("persona", new PersonaModelo());
		return new ModelAndView(ViewRouteHelper.PERSONA_FORM);
	}
	
	@PostMapping("/nuevapersona")
	public ModelAndView nuevaPersona(@Valid @ModelAttribute("persona") PersonaModelo persona, BindingResult b) {
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.PERSONA_FORM);
		} else {
			personaService.insertOrUpdate(persona);
			mV.setViewName(ViewRouteHelper.PERSONA_NEW);
			mV.addObject("persona", persona);
			mV.addObject("listaPersonas", personaService.getAll());
		}		
		return mV;
	}
}
