package com.example.ejemplos_videos.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_videos.helpers.ViewRouteHelper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserControlador {

	@GetMapping("/login")
	public ModelAndView login(Model model,
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return new ModelAndView(ViewRouteHelper.USER_LOGIN);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return ViewRouteHelper.USER_OUT;
	}
	
//	@GetMapping("/logout")
//	public ModelAndView logout() {
//		return new ModelAndView(ViewRouteHelper.USER_OUT);
//	}
	
	@GetMapping("/loginsuccess")
	public ModelAndView loginCheck() {
		return new ModelAndView(ViewRouteHelper.PERSONA_FORM); // redirect:/index
	}
}
