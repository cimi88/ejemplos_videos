package com.example.ejemplos_videos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_videos.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/primerprueba")
public class PrimerPruebaControlador {
	
	@GetMapping("nombre/{nombre_variable}")
	public ModelAndView CambiarNombre(@PathVariable("nombre_variable") String nombre_variable) {
		ModelAndView modelV = new ModelAndView(ViewRouteHelper.INDEX2);
		modelV.addObject("variableParaTemplate", nombre_variable);
		return modelV;
	}
	
	@GetMapping("nombre") /* .../nombre?name=juan  */
	public ModelAndView CambiarNombre2(@RequestParam(name="name", required=true, defaultValue="null") String name) {
		ModelAndView modelV = new ModelAndView(ViewRouteHelper.INDEX2);
		modelV.addObject("variableParaTemplate", name);
		return modelV;
	}
	
	@GetMapping("iniciando")
	public String IniciandoElCurso() {
		return ViewRouteHelper.INDEX_INICIANDO;
	}
	
	@GetMapping("")
	public String inicio() {
		return ViewRouteHelper.INDEX;
	}

}
