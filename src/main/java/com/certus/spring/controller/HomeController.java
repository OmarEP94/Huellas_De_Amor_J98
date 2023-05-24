package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class HomeController {

	@Value("${title.generic}")
	private String titlePage;

	@Value("${mensaje}")
	private String mensaje;

	@GetMapping({ "/home", "/inicio", "/", "/Home", "/Inicio" })
	public String Home(Model model) {

		return "Home";

	}

	@GetMapping({ "/integrantes" })
	public String Integrantes(Model model) {

		return "Integrantes";

	}

}
