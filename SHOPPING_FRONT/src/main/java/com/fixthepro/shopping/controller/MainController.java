package com.fixthepro.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickHome", true);
		mv.addObject("title", "Home");
		return mv;
	}
	
	@GetMapping(value= {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickAbout", true);
		mv.addObject("title", "About Us");
		return mv;
	}
	
	@GetMapping(value= {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickContact", true);
		mv.addObject("title", "Contact Us");
		return mv;
	}
}
